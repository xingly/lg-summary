package com.eason.设计模式.工厂方法模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:08 2018/2/10
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct product = factory.createProduct();
        product.productMethod();
    }

}
