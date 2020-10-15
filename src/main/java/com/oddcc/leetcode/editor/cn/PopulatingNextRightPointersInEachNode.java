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
            bfs(root);
            return root;
        }

        private void bfs(Node root) {
            if (root == null) return;
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(root, 1));
            Node pre = new Node(); // dummyRoot
            int lastDepth = 0;
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                // 当前节点深度跟之前不同，则说明进入了下一层，此时的pre是上一层的节点，要把next设为null
                if (pair.depth != lastDepth) {
                    pre.next = null;
                    pre = pair.node;
                    lastDepth = pair.depth;
                }
                // 当前节点深度跟之前相同，说明在同一层之内
                else {
                    pre.next = pair.node;
                    pre = pair.node;
                }
                System.out.format("%d-%d\n", pair.node.val, pair.depth);
                if (pair.node.left != null) {
                    queue.offer(new Pair(pair.node.left, pair.depth + 1));
                }
                if (pair.node.right != null) {
                    queue.offer(new Pair(pair.node.right, pair.depth + 1));
                }
            }
        }

        class Pair {
            public Node node;
            public int depth;

            public Pair(Node node, int depth) {
                this.node = node;
                this.depth = depth;
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