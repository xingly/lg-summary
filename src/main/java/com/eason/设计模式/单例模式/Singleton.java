package com.eason.设计模式.单例模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 14:58 2018/2/10
 * @Modified By:
 */
public class Singleton {

    // 饿汉模式
//    private static final Singleton instance = new Singleton();
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        return instance;
//    }

    // 懒汉模式（双重检查锁）
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    // 懒汉模式（静态内部类）
//    private static class SingletonHolder{
//        public static Singleton instance = new Singleton();
//    }
//    private Singleton(){}
//    public static Singleton newInstance(){
//        return SingletonHolder.instance;
//    }

}
