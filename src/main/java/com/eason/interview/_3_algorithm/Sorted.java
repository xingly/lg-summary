package com.eason.interview._3_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Sorted {

    /**
     * 直接插入排序
     * @param a
     */
    private static void insertSort(int[] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                int tmp = a[i];
                int j = i -1;
                while (j >= 0 && tmp < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = tmp;
            }
        }
    }


    /**
     * 希尔排序
     * @param a
     * @param n
     */
    private static void shellSort(int[] a, int n) {
       for(int gap = n / 2; gap > 0; gap /= 2 ) {
           for(int i = gap; i < n; i++) {
               if (a[i] < a[i - gap]) {
                   int temp = a[i];
                   int j = i - gap;
                   while (j >= 0 && temp < a[j]) {
                       a[j + gap] = a[j];
                       j -= gap;
                   }
                   a[j + gap] = temp;
               }
           }
       }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    private static void selectSort(int[] a, int n) {
        for(int i = 0; i < n; i++) {
            int min = a[i];
            int index = i;
            for(int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = min;
            a[index] = temp;
        }

    }

    /**
     * 冒泡排序
     * @param a
     * @param n
     */
    private static void bubbleSort(int[] a, int n) {
        for(int i = 1; i < n; i++) {// 标记第几趟排序 n个数排序n-1趟
            for(int j = 0; j < n - i; j++) {//
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    private static void quickSort(int[] items, int left, int right) {
        int i,j;
        int pivot,temp;
        i = left;
        j = right;
        pivot = items[(left + right) / 2];

        do {
            while (items[i] < pivot && i < right) {
                i++;
            }
            while (items[j] > pivot && j > left) {
                j--;
            }
            if (i <= j) {
                temp = items[i];
                items[i] = items[j];
                items[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) {
            quickSort(items, left, j);
        }
        if (i < right) {
            quickSort(items, i, right);
        }
    }


    public static void main(String[] args) {
        int[] a = {2, 1, 3, 5, 6, 9, 8, 1, 10, 6};
        int n = a.length;

//        insertSort(a);
//        shellSort(a, n);
//        selectSort(a, n);
//        bubbleSort(a, n);
        quickSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }


    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

}
