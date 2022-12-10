package com.oddcc.leetcode.editor.cn.common;

import java.util.*;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

    public static Node constructFromArr(Integer... arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        int i = 1;
        Node root = new Node(arr[0]);
        List<Node> lastLayer = new LinkedList<>();
        lastLayer.add(root);
        while (i < arr.length) {
            List<Node> curLayer = new LinkedList<>();
            for (Node node : lastLayer) {
                node.left = (i >= arr.length || arr[i] == null) ? null : new Node(arr[i]);
                i++;
                if (node.left != null) curLayer.add(node.left);
                node.right = (i >= arr.length || arr[i] == null) ? null : new Node(arr[i]);
                i++;
                if (node.right != null) curLayer.add(node.right);
            }
            lastLayer = curLayer;
        }
        return root;
    }

    public static Integer[] toArr(Node root) {
        if (root == null) return new Integer[0];
        Deque<Node> queue = new LinkedList<>();
        queue.addFirst(root);
        List<String> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node n = queue.removeLast();
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
}
