package com.eason.设计模式.抽象工厂模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:47 2018/2/10
 * @Modified By:
 */
public class Factory implements IFactory {
    @Override
    public IProductA createProductA() {
        return new ProductA();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB();
    }
}
