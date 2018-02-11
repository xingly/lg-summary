package com.eason.设计模式.工厂方法模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:15 2018/2/10
 * @Modified By:
 */
public class Factory implements IFactory {

    @Override
    public IProduct createProduct() {
        return new Product();
    }
}
