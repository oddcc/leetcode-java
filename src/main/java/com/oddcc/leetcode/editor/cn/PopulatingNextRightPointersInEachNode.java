package com.oddcc.leetcode.editor.cn;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        Node n1 = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        solution.connect(n1);
        System.out.println(n1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用层次遍历\BFS会有O(n)的空间复杂度，与题目要求的O(1)的空间复杂度不符
        // 题目给出，这是一颗完美二叉树（perfect binary tree），每个非叶子节点必定有左子树和右子树
        // 设当前节点为n的话，则有n.left.next = n.right，如果nn为n.next，则有n.right.next = nn.left
        // 即下一层的next关系，可以通过上一层的节点来获得
        public Node connect(Node root) {
            if (root == null) return null;
            Node head = root;
            while (head != null) {
                Node cur = head;
                while (cur != null) {
                    if (cur.left == null) break;
                    cur.left.next = cur.right;
                    Node tmp = cur.right;
                    cur = cur.next;
                    if (cur != null) {
                        tmp.next = cur.left;
                    }
                }
                head = head.left;
            }
            return root;
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