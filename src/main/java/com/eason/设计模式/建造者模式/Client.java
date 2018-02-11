package com.eason.设计模式.建造者模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 16:38 2018/2/10
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        Product product1 = director.getAProduct();
        product1.showProduct();

        Product product2 = director.getBProduct();
        product2.showProduct();
    }
}
