package com.eason.设计模式.建造者模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 16:13 2018/2/10
 * @Modified By:
 */
abstract class Builder {
    public abstract void setPart(String args1, String args2);

    public abstract Product getProduct();
}
