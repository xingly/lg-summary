package com.eason.interview._1_concurrent._4_Condition_ReadWriteLock_ReentrantLock;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者-消费者模型实现
 * 生产者-消费者问题，其实就是阻塞问题，
 * 如何控制队列长度，以及如何匹配生产和消费的速度？？？
 * 有两种实现方式：1、直接使用Lock和Condition的方式;
 * 2、使用阻塞队列，put和take方法生产和消费队列元素，其实这两个方法内部也是采用Condition方式实现
 *
 * @author jimi
 * @version 2017-01-03 17:35.
 */
public class ProducerAndConsumerTest {

    private static List<Integer> data = new LinkedList<>();
    private static int MAX_LEN = 20;

    /**
     *
     */
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();

    private void test(){
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 5; ++ i){
            executor.submit(new Producer(i));
            executor.submit(new Consumer(i));
        }

        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
    }

    public static void main(String[] args) {
        new ProducerAndConsumerTest().test();
    }

    class Producer implements Runnable{

        private int pid ;

        public Producer(int pid) {
            this.pid = pid;
        }

        @Override
        public void run() {
            while (true && !Thread.currentThread().isInterrupted()){
                try {
                    lock.lock();
                    if (data.size() >= MAX_LEN){
                        System.out.println("Producer" + pid + " waiting ! size : " + data.size());
                        notFull.await();
                    }

                    Random random = new Random();
                    data.add(random.nextInt());

                    notEmpty.signal();
                    System.out.println("Producer" + pid + " add " + pid + " size: " + data.size());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable{
        private int cid;

        public Consumer(int cid) {
            this.cid = cid;
        }


        @Override
        public void run() {
            while (true && !Thread.currentThread().isInterrupted()){
                lock.lock();
                try {
                    if (data.size() == 0){
                        System.out.println("Consumer" + cid + " waiting, data size : " + data.size());
                        notEmpty.await();
                    }

                    data.remove(0);

                    notFull.signal();
                    System.out.println("Consumer" + cid + " consuming data " + cid +" data size : " + data.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
