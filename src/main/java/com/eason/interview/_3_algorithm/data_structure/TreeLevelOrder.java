package com.eason.interview._3_algorithm.data_structure;

import java.util.ArrayDeque;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 14:53 2018/3/2
 * @Modified By:
 */
public class TreeLevelOrder {

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.value + "");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


}
