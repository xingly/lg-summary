### 如何使用链表头


### 单链表反转

```
public static Node linked(Node head) {
        // cur 当前节点，pre前驱，post后继
        Node pre, cur, post;
        // 初始，cur指向第一个节点，pre指向cur前驱，post指向cur后继
        pre = head;
        cur = head.getNext();

        while (cur != null) {// 循环中，p.next指向前驱节点pre，pre、cur、post各向后移动一个节点
            post = cur.getNext();
            cur.setNext(pre);

            pre = cur;
            cur = post;
        }
        head.setNext(null);

        return pre;
    }
```

### 如何进行单链表的排序 (冒泡、归并、快排)

### 如何实现单链表交换任意两个元素（不包括表头）

### 如何寻找单链表的中间节点

### 如何删除单链表中的重复节点




### 如何检测一个较大的单链表是否有环？环的入口点

### 判断两个单链表（无环）是否交叉

### 如何合并两个有序链表（非交叉）