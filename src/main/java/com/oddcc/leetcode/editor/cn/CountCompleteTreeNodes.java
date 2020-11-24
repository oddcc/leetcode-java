// 222

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        System.out.println(solution.countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        // 思路1，返回完全二叉树有多少个节点，各种遍历方法
        // 深度优先遍历
        // 深度优先遍历非递归 -> 栈
        // todo 广度优先遍历
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Deque<TreeNode> s2 = new LinkedList<>();
                TreeNode node = stack.pop();
                s2.push(node);
                while (node.left != null) {
                    s2.push(node.left);
                    node = node.left;
                }
                while (!s2.isEmpty()) {
                    TreeNode n = s2.pop();
                    if (n.right != null) stack.push(n.right);
                    count++;
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}