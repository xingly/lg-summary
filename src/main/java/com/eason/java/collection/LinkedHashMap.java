package com.eason.java.collection;

import java.util.Map;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 17:27 2018/1/2
 * @Modified By:
 */
public class LinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new java.util.LinkedHashMap<>(16, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        System.out.println(map.get("3"));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
