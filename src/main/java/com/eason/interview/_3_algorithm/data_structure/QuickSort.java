package com.eason.interview._3_algorithm.data_structure;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 12:43 2018/3/1
 * @Modified By:
 */
public class QuickSort {

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int index = partition(a, left, right);
            quickSort(a, left, index - 1);
            quickSort(a, index + 1, right);
        }
    }

    public static int partition(int[] a, int left, int right) {
        int i, j, temp;
        i = left;
        j = right;
        int pivot = a[left];

        while (i < j) {
            while (a[j] >= pivot && i < j) {
                j--;
            }
            while (a[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[left] = a[i];
        a[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3,6, 9, 5, 2, 1, 7, 0};
        quickSort(a, 0, 9);
        for (int arr : a) {
            System.out.print(arr + ",");
        }
    }
}
