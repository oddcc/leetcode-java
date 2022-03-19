// 606

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
        System.out.println(solution.tree2str(TreeNode.constructFromArr(1,2,3,4)));
        System.out.println(solution.tree2str(TreeNode.constructFromArr(1,2,3,null,4)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public String tree2str(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                return sb.toString();
            }
            if (root.left != null) {
                sb.append("(").append(tree2str(root.left)).append(")");
            } else {
                sb.append("()");
            }
            if (root.right != null) {
                sb.append("(").append(tree2str(root.right)).append(")");
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}