package com.eason.interview._3_algorithm;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 20:30 2018/3/8
 * @Modified By:
 */
public class RotateWord {

    public static void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }

        // 翻转chas
        revers(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for(int i = 0; i < chas.length; i++) {
            if(chas[i] != ' '){
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }

            if (i != -1 && r != -1) {
                revers(chas, l, r);
                l = -1;
                r =-1;
            }
        }
    }

    public static void revers(char[] chas, int start, int end) {
        char temp = 0;
        while (start < end) {
            temp = chas[start];
            chas[start] = chas[end];
            chas[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String word = "I love  you";
        char[] chas = word.toCharArray();
        rotateWord(chas);
        System.out.println(String.valueOf(chas));
        System.out.println(Integer.MAX_VALUE);
    }
}