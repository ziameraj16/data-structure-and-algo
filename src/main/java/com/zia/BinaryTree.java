package com.zia;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        levelOrderTraversal();
    }

    private static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node60 = new TreeNode(60);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        root.left = node20;
        root.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        return root;
    }

    /**
     * 1. Find maximum element in left subtree
     * 2. Find maximum element in right subtree
     * 3. Compare maximum of above subtrees to current node
     * 4. We will find maximum element with above steps
     */
    private static int getMaxValue(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int value = 0;
        int left, right;
        if (root != null) {
            value = root.data;
            left = getMaxValue(root.left);
            right = getMaxValue(root.right);
            if (left > right) {
                max = left;
            } else {
                max = right;
            }

            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    /**
     * 1. If node is null then return 0
     * 2. Put node.data in array and increment len by 1.
     * 3. If encountered leaf node(i.e. node.left is null and node.right is null) then print array.
     * 4. Recursively visit left subtree and right subtree
     */
    private static void printAllPathsToLeaf(TreeNode node, int[] path, int length) {
        if (node == null) {
            return;
        }

        path[length] = node.data;
        length++;

        if (node.left == null && node.right == null) {
            printArray(path, length);
            return;
        }

        printAllPathsToLeaf(node.left, path, length);
        printAllPathsToLeaf(node.right, path, length);
    }

    private static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode (int data) {
            this.data = data;
        }
    }

    private static int treeDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = treeDepth(node.left);
        int right = treeDepth(node.right);
        return left > right ? left + 1 : right + 1;
    }

    private static void printArray(int[] path, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + path[i]);
        }
        System.out.println();
    }

    /**
     *     3
     *    /  \
     *   5    2
     *  / \  / \
     * 1  4 6  7
     *  \      /
     *   9    8
     *
     *   Ans: 15327
     */
    private static void topViewOfBinaryTree() {

        TreeNode root = createBinaryTreeForTopView();

        TreeNode r2 = root;
        Stack<Integer> stack = new Stack();
        stack.push(root.data);
        while (root.left != null) {
            stack.push(root.left.data);
            root = root.left;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(r2.right.data);
        r2 = r2.right;
        while (r2.right != null) {
            queue.add(r2.right.data);
            r2 = r2.right;
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

    private static TreeNode createBinaryTreeForTopView() {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);

        root.left = node5;
        root.right = node2;

        node5.left = node1;
        node5.right = node4;

        node2.left = node6;
        node2.right = node7;

        node1.right = node9;

        node7.left = node8;

        return root;
    }

    /**
     *     3
     *    /  \
     *   5    2
     *  / \  / \
     * 1  4 6  7
     *  \      /
     *   9    8
     *
     *   Ans: 352146798
     */
    private static void levelOrderTraversal() {
        TreeNode root = createBinaryTreeForTopView();

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.data);
            if (node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
    }
}
