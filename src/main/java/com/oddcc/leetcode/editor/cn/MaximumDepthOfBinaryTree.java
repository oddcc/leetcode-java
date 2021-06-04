// 104

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        TreeNode n = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.maxDepth(n));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            return walk(root, 0);
        }

        private int walk(TreeNode node, int depth) {
            // 当结点为null时，返回结果
            if (node == null) return depth;
            // 结点不为null，深度+1
            depth++;
            // 取左子树和右子树之中更深的那个结果
            return Integer.max(walk(node.left, depth), walk(node.right, depth));
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}

