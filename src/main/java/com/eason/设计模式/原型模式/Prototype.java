package com.eason.设计模式.原型模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 16:46 2018/2/10
 * @Modified By:
 */
public class Prototype implements Cloneable {

    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
