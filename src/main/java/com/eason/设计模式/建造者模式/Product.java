package com.eason.设计模式.建造者模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 16:11 2018/2/10
 * @Modified By:
 */
public class Product {
    private String name;
    private String type;

    public void showProduct() {
        System.out.println("名称：" + name);
        System.out.println("型号：" + type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
