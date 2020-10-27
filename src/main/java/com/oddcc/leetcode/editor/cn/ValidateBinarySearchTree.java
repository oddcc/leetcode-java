package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
//        System.out.println(solution.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
//        System.out.println(solution.isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
        System.out.println(solution.isValidBST(new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(5, new TreeNode(4), new TreeNode(6)))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路2，递归，如果左子树是BST，且左子节点的值小于root，如果右子树是BST，且右子节点的值大于root，那么root就是BST
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
            if (root == null) return true;
            if (root.left != null && root.left.val >= root.val) return false;
            if (root.right != null && root.right.val <= root.val) return false;
            if (root.val <= minValue || root.val >= maxValue) return false;
            return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}