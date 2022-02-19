package com.oddcc.leetcode.editor.cn.common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        TreeNode n = TreeNode.constructFromArr(1, 2, 3, null, null, 4, null, null, 5);
        // System.out.println(Arrays.toString(TreeNode.toArr(n)));
        System.out.println("inorderTraversal=====");
        inorderTraversal(n);
        System.out.println("preorderTraversal=====");
        preorderTraversal(n);
        System.out.println("postorderTraversal=====");
        postorderTraversal(n);
    }

    public static TreeNode constructFromArr(Integer... arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        int i = 1;
        TreeNode root = new TreeNode(arr[0]);
        List<TreeNode> lastLayer = new LinkedList<>();
        lastLayer.add(root);
        while (i < arr.length) {
            List<TreeNode> curLayer = new LinkedList<>();
            for (TreeNode node : lastLayer) {
                node.left = (i >= arr.length || arr[i] == null) ? null : new TreeNode(arr[i]);
                i++;
                if (node.left != null) curLayer.add(node.left);
                node.right = (i >= arr.length || arr[i] == null) ? null : new TreeNode(arr[i]);
                i++;
                if (node.right != null) curLayer.add(node.right);
            }
            lastLayer = curLayer;
        }
        return root;
    }

    public static Integer[] toArr(TreeNode root) {
        if (root == null) return new Integer[0];
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        List<String> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode n = queue.removeLast();
                if (n == null) {
                    nodes.add("null");
                    continue;
                }
                nodes.add(Integer.toString(n.val));
                queue.addFirst(n.left);
                queue.addFirst(n.right);
            }
            if (queue.stream().allMatch(Objects::isNull)) break;
        }
        Integer[] ans = new Integer[nodes.size()];
        for (int i = 0; i < ans.length; i++) {
            String s = nodes.get(i);
            if (s.equals("null")) {
                ans[i] = null;
            }
            else {
                ans[i] = Integer.valueOf(s);
            }
        }
        return ans;
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
