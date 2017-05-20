package com.eason.interview._11_redis;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Test {
    public static void main(String[] args) {
        int i = 0;
        while (i < 100) {
            int random = (int)(Math.random() * 100);
            System.out.println(random);
            i++;
        }
    }
}
