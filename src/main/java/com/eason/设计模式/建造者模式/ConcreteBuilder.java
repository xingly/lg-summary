package com.eason.设计模式.建造者模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 16:16 2018/2/10
 * @Modified By:
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();

    @Override
    public void setPart(String args1, String args2) {
        product.setName(args1);
        product.setType(args2);

    }

    @Override
    public Product getProduct() {
        return product;
    }
}
