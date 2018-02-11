package com.eason.设计模式.建造者模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 16:19 2018/2/10
 * @Modified By:
 */
public class Director {
    private Builder builder = new ConcreteBuilder();

    public Product getAProduct() {
        builder.setPart("宝马汽车", "X7");
        return builder.getProduct();
    }

    public Product getBProduct() {
        builder.setPart("奥迪汽车", "Q5");
        return builder.getProduct();
    }
}
