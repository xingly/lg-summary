package com.eason.设计模式.抽象工厂模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:48 2018/2/10
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {
        IFactory factory = new Factory();
        factory.createProductA().show();
        factory.createProductB().show();
    }
}
