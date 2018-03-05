package com.eason.interview._3_algorithm.data_structure.linkedList;

/**
 * Created by max406 on 2017/5/15.
 */
public class LinkedList {

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        head.next = node1;
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;

        head = reverseList(head);
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null) {
                System.out.print(",");
            }
        }
    }
}

