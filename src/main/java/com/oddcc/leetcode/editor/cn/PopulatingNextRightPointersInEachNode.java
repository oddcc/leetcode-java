package com.oddcc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        Node n1 = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        solution.bfs(n1);
        System.out.println(n1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            bfs(root);
            return root;
        }

        private void bfs(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                Node pre = null;
                for (int i = 0; i < len; i++) {
                    Node node = queue.poll();
                    if (pre == null) {
                        pre = node;
                    }
                    else {
                        pre.next = node;
                        pre = node;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};