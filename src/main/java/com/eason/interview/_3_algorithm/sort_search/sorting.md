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
private static void insertSort(int[] a, int n) {
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

时间复杂度：O（n^2）


#### 2. 插入排序—希尔排序(Shell`s Sort)

- 算法思想

先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。

希尔排序示例

![](http://img.my.csdn.net/uploads/201207/18/1342577299_5077.jpg)

- 算法实现

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

- 算法思想

在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。

简单选择排序的示例：

![](http://img.my.csdn.net/uploads/201207/18/1342586432_7130.jpg)

- 算法实现
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

- 算法思想

利用完全二叉树中双亲节点和孩子节点之间的内在关系，在当前无序区中选择关键字最大(或者最小)的记录。也就是说，以最小堆为例，根节点为最小元素，较大的节点偏向于分布在堆底附近。

- 算法实现

```

```


#### 5. 交换排序—冒泡排序(Bubble Sort)

- 算法思想

利用完全二叉树中双亲节点和孩子节点之间的内在关系，在当前无序区中选择关键字最大(或者最小)的记录。也就是说，以最小堆为例，根节点为最小元素，较大的节点偏向于分布在堆底附近。

- 算法实现

```
private static void bubbleSort(int[] a, int n) {
        for(int i = 1; i < n; i++) {// 标记第几趟排序 n个数排序n-1趟
            for(int j = 0; j < n - i; j++) {//
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

```


#### 6. 交换排序—快速排序(Quick Sort)

- 算法思想

它是由冒泡排序改进而来的。在待排序的n个记录中任取一个记录(通常取第一个记录),把该记录放入适当位置后,数据序列被此记录划分成两部分。所有关键字比该记录关键字小的记录放置在前一部分,所有比它大的记录放置在后一部分,并把该记录排在这两部分的中间(称为该记录归位),这个过程称作一趟快速排序。

- 算法实现

```
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

```


#### 7. 归并排序(Merge Sort)

- 算法思想

- 算法实现

```

```

#### 8. 桶排序/基数排序(Radix Sort)

- 算法思想

- 算法实现

```

```

### 总结

稳定排序：简单插入排序，冒泡排序，归并排序，基数排序
不稳定的排序：希尔排序，快速排序，简单选择排序，堆排序



