package com.eason.设计模式.抽象工厂模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:46 2018/2/10
 * @Modified By:
 */
public interface IFactory {

    public IProductA createProductA();

    public IProductB createProductB();
}
