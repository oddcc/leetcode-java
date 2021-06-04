// 226

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        TreeNode n1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        solution.invertTree(n1);
        System.out.println("done");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            doInvert(root);
            return root;
        }

        private void doInvert(TreeNode root) {
            if (root.left != null) {
                doInvert(root.left);
            }
            if (root.right != null) {
                doInvert(root.right);
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}