package com.eason.interview._3_algorithm;

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

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 5, 6, 9, 8, 1, 10, 6};
        int n = a.length;

//        insertSort(a);
//        shellSort(a, n);
        selectSort(a, n);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }


    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

}
