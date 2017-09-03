package com.zia;

public class BinarySearchTree {

    private static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode (int data) {
            this.data = data;
        }
    }

    private static TreeNode getMin(TreeNode root) {
        if (root.left == null) {
            return root;
        } else {
            return  getMin(root.left);
        }
    }
}
