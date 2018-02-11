package com.eason.设计模式.单例模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 14:58 2018/2/10
 * @Modified By:
 */
public class Singleton {

    // 饿汉模式
//    private static Singleton instance = new Singleton();
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        return instance;
//    }

    // 懒汉模式
//    private static Singleton instance;
//
//    private Singleton() {}
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }


    // 懒汉模式（静态内部类）
    private static class SingletonHolder{
        public static Singleton instance = new Singleton();
    }
    private Singleton(){}
    public static Singleton newInstance(){
        return SingletonHolder.instance;
    }

}
