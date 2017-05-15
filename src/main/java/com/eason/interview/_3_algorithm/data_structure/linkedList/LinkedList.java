package com.eason.interview._3_algorithm.data_structure.linkedList;

/**
 * Created by max406 on 2017/5/15.
 */
public class LinkedList {

    public static Node linked(Node head) {
        Node pre, cur, post;
        pre = head;
        cur = head.getNext();

        while (cur != null) {
            post = cur.getNext();
            cur.setNext(pre);

            pre = cur;
            cur = post;
        }
        head.setNext(null);

        return pre;
    }


    public static void main(String[] args) {
        Node head = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        node1.setData("1");
        node2.setData("2");
        node3.setData("3");
        node4.setData("4");
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        Node convertNode = linked(head);
        System.out.println(convertNode.getData());
    }
}

