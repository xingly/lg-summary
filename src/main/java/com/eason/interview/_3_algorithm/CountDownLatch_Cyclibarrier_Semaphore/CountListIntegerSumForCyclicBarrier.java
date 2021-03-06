package com.eason.interview._3_algorithm.CountDownLatch_Cyclibarrier_Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个10w个整数的列表，充分利用cpu性能，尽可能快的计算出列表的总和
 *
 * @author jimi
 * @version 2016-12-26 22:58.
 */
public class CountListIntegerSumForCyclicBarrier {

    /*
    可用cpu数
     */
    private int threadCount = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    /*
     对于这个成员变量，线程不能保存它的私有拷贝，都强迫从主内存读取该变量值，
     从而保证在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
     */
    private volatile long sum;

    public CountListIntegerSumForCyclicBarrier() {
    }

    public long countSum(List<Integer> list) {
        int len = list.size() / threadCount;

        //+1原因：
        //用于控制main主线程的，主线程也要等待，它要等待其他所有的线程完成才能输出sum值，这样才能保证sum值的正确性，如果main不等待的话，那么结果将是不可预料的。
        final CyclicBarrier barrier = new CyclicBarrier(threadCount + 1);

        for (int i = 0; i < threadCount; i++) {
            final List<Integer> subList;
            int fromIndex = i * len;
            final int index = i + 1;
            int toIndex = index * len;
            subList = list.subList(fromIndex, toIndex);
            System.out.println("[subList]index=" + index + ", size=" + subList.size() + ", values= " + subList
                    .toString());

            //所以不需要返回值方式
            executor.execute(new Runnable() {
                private Long subSum = 0L;

                @Override
                public void run() {
                    for (Integer i : subList) {
                        subSum += i;
                    }

                    //用于测试多线程是否并发执行
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("[subList]index=" + index + ", subSum = " + subSum);

                    //在CountListIntegerSum对象上加锁
                    //注：此处锁的不能是Long、Short、Integer等型对象，因为在加法计算时，会重新解箱和封箱，sum就不是原来对象了，进而同步块就失效了
                    synchronized (this) {
                        sum += subSum;
                    }
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();

        //注：用于等待所有计算线程执行完成，再返回值，否则，会出现不可预料的错误。
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        return sum;
    }


    public static void main(String[] args) {
        int initCap = 100000;
        List<Integer> integerList = new ArrayList<>(initCap);
        for (int i = 0; i < initCap; i++) {
            integerList.add(i + 1);
        }

        CountListIntegerSumForCyclicBarrier countListIntegerSum = new CountListIntegerSumForCyclicBarrier();
        long sum = countListIntegerSum.countSum(integerList);

        //正确结果：5000050000
        System.out.println("sum = " + sum);
    }
}
