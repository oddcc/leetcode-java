//Given a binary tree and a sum, determine if the tree has a root-to-leaf path s
//uch that adding up all the values along the path equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
// 
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. 
//
// Related Topics 树 深度优先搜索 
// 👍 434 👎 0


package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
//        TreeNode n1 = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
//        System.out.println(solution.hasPathSum(n1, 22));
        TreeNode n2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(solution.hasPathSum(n2, 2));
//        TreeNode n3 = new TreeNode(1);
//        System.out.println(solution.hasPathSum(n3, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            return findSum(root, 0, sum);
        }

        private boolean findSum(TreeNode node, int sum, int target) {
            if (node.left == null && node.right == null) return sum + node.val == target;
            sum = node.val + sum;
            return (node.left != null && findSum(node.left, sum, target))
                    || (node.right != null && findSum(node.right, sum, target));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}