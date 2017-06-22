package com.eason;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/18.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(f(7));
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");

    }
    public static int f(int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }
}
