//Given a binary tree, find its maximum depth. 
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its depth = 3. 
// Related Topics 树 深度优先搜索 
// 👍 706 👎 0


package com.oddcc.leetcode.editor.cn;

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

