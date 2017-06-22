package com.eason.interview;

import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/5/21.
 */
public class Tetst {

    public static void depthFirst(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.getName());

            List<TreeNode> childen = node.getChilden();
            if (childen != null && !childen.isEmpty()) {
                for (TreeNode treeNode : childen) {
                    stack.push(treeNode);
                }
            }
        }
    }


    private static class TreeNode{
        private String name;
        private List<TreeNode> childen;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<TreeNode> getChilden() {
            return childen;
        }

        public void setChilden(List<TreeNode> childen) {
            this.childen = childen;
        }
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        int[] mergeArray = new int[length1 + length2];
        int i = 0;
        int j = 0;

        while (length1 > i && length2 > j) {
            if (array1[i] > array2[j]) {
                mergeArray[i + j] = array2[j];
                j++;
            }else {
                mergeArray[i + j] = array1[i];
                i++;
            }
        }

        while (length1 > i) {
            mergeArray[i + j] = array1[i];
            i++;
        }

        while (length2 > j) {
            mergeArray[i + j] = array2[j];
            j++;
        }

        return mergeArray;
    }

    public static void randomArray(int[] array) {
        int length = array.length;
        for(int i = length - 1; i >= 0; i--) {
            int random = random();
            int temp = array[i];
            array[i] = array[random];
            array[random] = temp;
        }
    }

    public static int random() {
        return (int)(Math.random() * 100);
    }
}
