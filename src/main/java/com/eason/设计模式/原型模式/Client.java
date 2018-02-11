package com.eason.设计模式.原型模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 16:48 2018/2/10
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        for(int i = 0; i< 10; i++) {
            ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
            clonecp.show();
        }
    }
}
