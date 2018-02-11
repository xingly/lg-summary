package com.eason.java.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 14:25 2017/12/26
 * @Modified By:
 */
public class HahMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "aaa");
        map.put("aaa", "bbb");
        System.out.println(map.get("aaa"));


        System.out.println(map.hashCode());
    }
}
