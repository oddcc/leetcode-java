package com.oddcc.leetcode.editor.cn.common;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        inorderTraversal(n);
        System.out.println("=====");
        preorderTraversal(n);
        System.out.println("=====");
        postorderTraversal(n);
    }

    public static void inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                // 输出是在节点出栈时进行
                System.out.println(root.val);
                // 已经访问过root和它的左子树了
                root = root.right;
            }
        }
    }

    // 与中序遍历逻辑相同，只是输出的时机不同
    public static void preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.println(root.val);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || pre == root.right) {
                System.out.println(root.val);
                pre = root;
                root = null;
            }
            else {
                stack.push(root);
                root = root.right;
            }
        }
    }
}
