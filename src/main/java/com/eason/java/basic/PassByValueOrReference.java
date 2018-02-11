package com.eason.java.basic;

/**
 * @Author: eason
 * @Description: 值传递、引用传递
 * @Date: Create in 13:36 2018/1/2
 * @Modified By:
 */
public class PassByValueOrReference {

    public String name = null;

    public PassByValueOrReference(String name) {
        this.name = name;
    }

    public static void swap(PassByValueOrReference e1, PassByValueOrReference e2) {
        PassByValueOrReference temp = e1;
        e1 = e2;
        e2 = temp;
        e1.name = "王五";
    }

    public static void main(String[] args) {
        PassByValueOrReference e1 = new PassByValueOrReference("张三");
        PassByValueOrReference e2 = new PassByValueOrReference("李四");
        swap(e1, e2);
        System.out.println("输出：" +e1.name + "," + e2.name);
    }
}
