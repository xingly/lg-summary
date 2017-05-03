CountDownLatch是通过“共享锁”实现的。下面，我们分析CountDownLatch中3个核心函数: CountDownLatch(int count), await(), countDown()。
1. CountDownLatch(int count)

```
public CountDownLatch(int count) {
    if (count < 0) throw new IllegalArgumentException("count < 0");
    this.sync = new Sync(count);
}
```
说明：该函数是创建一个Sync对象，而Sync是继承于AQS类。Sync构造函数如下：

```
Sync(int count) {
    setState(count);
}
```

setState()在AQS中实现，源码如下：
```
protected final void setState(long newState) {
    state = newState;
}
```
说明：在AQS中，state是一个private volatile long类型的对象。对于CountDownLatch而言，state表示的”锁计数器“。CountDownLatch中的getCount()最终是调用AQS中的getState()，返回的state对象，即”锁计数器“。

2. await()
```
public void await() throws InterruptedException {
    sync.acquireSharedInterruptibly(1);
}
```
说明：该函数实际上是调用的AQS的acquireSharedInterruptibly(1);
AQS中的acquireSharedInterruptibly()的源码如下：
```
public final void acquireSharedInterruptibly(long arg)
        throws InterruptedException {
    if (Thread.interrupted())
        throw new InterruptedException();
    if (tryAcquireShared(arg) < 0)
        doAcquireSharedInterruptibly(arg);
}
```
说明：acquireSharedInterruptibly()的作用是获取共享锁。
如果当前线程是中断状态，则抛出异常InterruptedException。否则，调用tryAcquireShared(arg)尝试获取共享锁；尝试成功则返回，否则就调用doAcquireSharedInterruptibly()。doAcquireSharedInterruptibly()会使当前线程一直等待，直到当前线程获取到共享锁(或被中断)才返回。

tryAcquireShared()在CountDownLatch.java中被重写，它的源码如下：
```
protected int tryAcquireShared(int acquires) {
    return (getState() == 0) ? 1 : -1;
}
```
说明：tryAcquireShared()的作用是尝试获取共享锁。
如果"锁计数器=0"，即锁是可获取状态，则返回1；否则，锁是不可获取状态，则返回-1。
```
private void doAcquireSharedInterruptibly(long arg)
    throws InterruptedException {
    // 创建"当前线程"的Node节点，且Node中记录的锁是"共享锁"类型；并将该节点添加到CLH队列末尾。
    final Node node = addWaiter(Node.SHARED);
    boolean failed = true;
    try {
        for (;;) {
            // 获取上一个节点。
            // 如果上一节点是CLH队列的表头，则"尝试获取共享锁"。
            final Node p = node.predecessor();
            if (p == head) {
                long r = tryAcquireShared(arg);
                if (r >= 0) {
                    setHeadAndPropagate(node, r);
                    p.next = null; // help GC
                    failed = false;
                    return;
                }
            }
            // (上一节点不是CLH队列的表头) 当前线程一直等待，直到获取到共享锁。
            // 如果线程在等待过程中被中断过，则再次中断该线程(还原之前的中断状态)。
            if (shouldParkAfterFailedAcquire(p, node) &&
                parkAndCheckInterrupt())
                throw new InterruptedException();
        }
    } finally {
        if (failed)
            cancelAcquire(node);
    }
}
```
说明：
(01) addWaiter(Node.SHARED)的作用是，创建”当前线程“的Node节点，且Node中记录的锁的类型是”共享锁“(Node.SHARED)；并将该节点添加到CLH队列末尾。关于Node和CLH在"Java多线程系列--“JUC锁”03之 公平锁(一)"已经详细介绍过，这里就不再重复说明了。
(02) node.predecessor()的作用是，获取上一个节点。如果上一节点是CLH队列的表头，则”尝试获取共享锁“。
(03) shouldParkAfterFailedAcquire()的作用和它的名称一样，如果在尝试获取锁失败之后，线程应该等待，则返回true；否则，返回false。
(04) 当shouldParkAfterFailedAcquire()返回ture时，则调用parkAndCheckInterrupt()，当前线程会进入等待状态，直到获取到共享锁才继续运行。
doAcquireSharedInterruptibly()中的shouldParkAfterFailedAcquire(), parkAndCheckInterrupt等函数在"Java多线程系列--“JUC锁”03之 公平锁(一)"中介绍过，这里也就不再详细说明了。

3. countDown()
```
public void countDown() {
    sync.releaseShared(1);
}
```
说明：该函数实际上调用releaseShared(1)释放共享锁。

releaseShared()在AQS中实现，源码如下：
```
public final boolean releaseShared(int arg) {
    if (tryReleaseShared(arg)) {
        doReleaseShared();
        return true;
    }
    return false;
}
```
说明：releaseShared()的目的是让当前线程释放它所持有的共享锁。
它首先会通过tryReleaseShared()去尝试释放共享锁。尝试成功，则直接返回；尝试失败，则通过doReleaseShared()去释放共享锁。

tryReleaseShared()在CountDownLatch.java中被重写，源码如下：
```
protected boolean tryReleaseShared(int releases) {
    // Decrement count; signal when transition to zero
    for (;;) {
        // 获取“锁计数器”的状态
        int c = getState();
        if (c == 0)
            return false;
        // “锁计数器”-1
        int nextc = c-1;
        // 通过CAS函数进行赋值。
        if (compareAndSetState(c, nextc))
            return nextc == 0;
    }
}
```
说明：tryReleaseShared()的作用是释放共享锁，将“锁计数器”的值-1。



总结：CountDownLatch是通过“共享锁”实现的。在创建CountDownLatch中时，会传递一个int类型参数count，该参数是“锁计数器”的初始状态，表示该“共享锁”最多能被count给线程同时获取。当某线程调用该CountDownLatch对象的await()方法时，该线程会等待“共享锁”可用时，才能获取“共享锁”进而继续运行。而“共享锁”可用的条件，就是“锁计数器”的值为0！而“锁计数器”的初始值为count，每当一个线程调用该CountDownLatch对象的countDown()方法时，才将“锁计数器”-1；通过这种方式，必须有count个线程调用countDown()之后，“锁计数器”才为0，而前面提到的等待线程才能继续运行！

以上，就是CountDownLatch的实现原理。