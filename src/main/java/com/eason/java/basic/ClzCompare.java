package com.eason.java.basic;

/**
 * @Author: eason
 * @Description: getClass方法与类直接获得class对象是否相等
 * @Date: Create in 15:25 2018/1/23
 * @Modified By:
 */
public class ClzCompare {

    public static void main(String[] args) {
        ClzCompare clzCompare = new ClzCompare();

        Class<? extends ClzCompare> clz = clzCompare.getClass();

        Class<ClzCompare> clz2 = ClzCompare.class;

        System.out.println(clz.equals(clz2));
    }
}
