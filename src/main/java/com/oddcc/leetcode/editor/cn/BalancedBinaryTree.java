// 110

package com.oddcc.leetcode.editor.cn;


import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class BalancedBinaryTree {
//    static int count = 0;
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
//        TreeNode n1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        System.out.println(solution.isBalanced(n1));
//        TreeNode n2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
//        System.out.println(solution.isBalanced(n2));
        TreeNode n3 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        System.out.println(solution.isBalanced(n3));
//        System.out.println(count);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isBalanced(TreeNode root) {
            // a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
            // 定义很重要，不是一般意义上的平衡树，要求每个结点的左子树和右子树的高度差都不能超过1
            if (root == null) return true;
            int lDepth = getDepth(root.left);
            if (lDepth == -1) return false;
            int rDepth = getDepth(root.right);
            if (rDepth == -1) return false;
            return Math.abs(lDepth - rDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        // 如果计算时发现左子树和右子树的高度差大于1，则返回-1，表示异常
        private int getDepth(TreeNode root) {
//            count++;
            if (root == null) return 0;
            int lDepth = getDepth(root.left);
            int rDepth = getDepth(root.right);
            if (Math.abs(lDepth - rDepth) > 1) return -1;
            return Math.max(lDepth, rDepth) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}