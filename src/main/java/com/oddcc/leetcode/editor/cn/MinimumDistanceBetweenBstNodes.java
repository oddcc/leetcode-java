// 783

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
        System.out.println(solution.minDiffInBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
        System.out.println(solution.minDiffInBST(new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)))));
        System.out.println(solution.minDiffInBST(new TreeNode(27, null, new TreeNode(34, null, new TreeNode(58, new TreeNode(50, new TreeNode(44), null), null)))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，对于root来说，如果知道左子树中的最大值，右子树中的最小值，就能算出最小距离
        // 因为右子树中都大于root，除了最小值之外，其他值的距离都会更大
        // 左子树中都小于root，除了最大值之外，其他值的距离都会更大
        // 一颗BST中，最大值为最右子节点，最小值为最左子节点
        public int minDiffInBST(TreeNode root) {
            if (root == null) return Integer.MAX_VALUE;
            int leftMax = root.left == null ? Integer.MAX_VALUE : findMax(root.left);
            int rightMin = root.right == null ? Integer.MAX_VALUE : findMin(root.right);
            return Math.min(Math.min(Math.min(Math.abs(root.val - leftMax), Math.abs(root.val - rightMin)), minDiffInBST(root.left)), minDiffInBST(root.right));
        }

        private int findMin(TreeNode root) {
            int ans = root.val;
            while (root.left != null) {
                ans = root.left.val;
                root = root.left;
            }
            return ans;
        }

        private int findMax(TreeNode root) {
            int ans = root.val;
            while (root.right != null) {
                ans = root.right.val;
                root = root.right;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}