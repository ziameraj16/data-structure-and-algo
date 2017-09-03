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

    private void printInOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }

    /**
     * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants.
     */
    private TreeNode lowestCommonAncestor(TreeNode node, int n1, int n2) {

        if (node == null) {
            return null;
        }
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data < n1 && node.data < n2) {
            return lowestCommonAncestor(node.left, n1, n2);
        }
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data > n1 && node.data > n2) {
            return lowestCommonAncestor(node.right, n1, n2);
        }
        return node;

    }
}
