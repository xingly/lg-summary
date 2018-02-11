package com.eason.设计模式.工厂方法模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:16 2018/2/10
 * @Modified By:
 */
public class Product implements IProduct {
    @Override
    public void productMethod() {
        System.out.println("产品");
    }
}
