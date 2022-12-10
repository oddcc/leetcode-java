// 117

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.Node;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeII().new Solution();
        System.out.println(solution.connect(Node.constructFromArr(1, 2, 3, 4, 5, null, 7)));
        System.out.println(solution.connect(Node.constructFromArr()));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> queue = new LinkedList<>();
            queue.add(root);
            Node previous = null;
            while (!queue.isEmpty()) {
                Deque<Node> tmpQueue = new LinkedList<>();
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Node n = queue.removeFirst();
                    if (previous != null) {
                        previous.next = n;
                    }
                    previous = n;
                    if (n.left != null) {
                        tmpQueue.add(n.left);
                    }
                    if (n.right != null) {
                        tmpQueue.add(n.right);
                    }
                }
                previous = null;
                while (!tmpQueue.isEmpty()) {
                    queue.add(tmpQueue.removeFirst());
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}