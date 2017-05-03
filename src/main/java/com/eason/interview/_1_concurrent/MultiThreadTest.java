package com.eason.interview._1_concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by eason on 2017/5/2.
 */
public class MultiThreadTest implements Runnable{
    private static int i;

    private static volatile Integer vi = 0;

    private static AtomicInteger ai = new AtomicInteger();

    private static Integer si = 0;

    private static int ri;

    private Lock lock = new ReentrantLock();

    private static CountDownLatch latch = new CountDownLatch(2);

    @Override
    public void run() {
        for(int k=0;k<2000000;k++){
            i++; // 类变量

            vi++; // volatile关键字

            ai.incrementAndGet(); // 原子类

            synchronized(si){ // synchronized关键字
                si++;
            }

            lock.lock(); // 锁
            try{
                ri++;
            }finally{
                lock.unlock();
            }
        }
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException{
        MultiThreadTest t1 = new MultiThreadTest();
        MultiThreadTest t2 = new MultiThreadTest();
        ExecutorService exec1 = Executors.newCachedThreadPool();
        ExecutorService exec2 = Executors.newCachedThreadPool();
        exec1.execute(t1);
        exec2.execute(t2);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("类变量i： "+i);
        System.out.println("volatile i: "+vi);
        System.out.println("原子类 i： "+ai);
        System.out.println("synchronized i: "+si);
        System.out.println("lock i: "+ri);

        exec1.shutdown();
        exec2.shutdown();
    }
}

