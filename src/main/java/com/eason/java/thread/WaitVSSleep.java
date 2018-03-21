package com.eason.java.thread;

import sun.awt.windows.ThemeReader;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 22:54 2018/1/31
 * @Modified By:
 */
public class WaitVSSleep {
    public static void main(String[] args) {
        Thread t1 = new SleepTest();
        Thread t2 = new SleepTest();
        System.out.println("线程名：" + Thread.currentThread().getName() + "开始");
        t1.start();
        t2.start();
        System.out.println("线程名：" + Thread.currentThread().getName() + "结束");
    }

}

class SleepTest extends Thread{
    @Override
    public void run() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "开始");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名：" + Thread.currentThread().getName() + "结束");
    }

}
