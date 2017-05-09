### 八大排序算法

![](http://img.my.csdn.net/uploads/201207/17/1342514529_5795.jpg)


#### 1. 插入排序-直接插入排序(Straight Insertion Sort)
- 算法思想

将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。

要点：设立哨兵，作为临时存储和判断数组边界之用。

直接插入示例：

![](http://img.my.csdn.net/uploads/201207/17/1342520948_8667.jpg)

- 算法实现
```
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
```
- 算法效率



#### 2. 插入排序—希尔排序(Shell`s Sort)


```
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
```



#### 3. 选择排序—简单选择排序(Simple Selection Sort)

```
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
```

#### 4. 选择排序—堆排序(Heap Sort)



#### 5. 交换排序—冒泡排序(Bubble Sort)



#### 6. 交换排序—快速排序(Quick Sort)




#### 7. 归并排序(Merge Sort)



#### 8. 桶排序/基数排序(Radix Sort)







