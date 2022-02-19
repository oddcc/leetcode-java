// 108

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        TreeNode n = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(n);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return getBST(nums, 0, nums.length);
        }

        // 用nums中的[start,end)的数据，生成一颗平衡二叉树
        private TreeNode getBST(int[] nums, int start, int end) {
            // 因为区间是个左闭右开的区间，相等时，实际没有元素了，所以返回null
            if (end - start == 0) return null;
            // 当相差1时，只有一个元素，直接返回这个元素的结点，没有左子树和又子树
            if (end - start == 1) return new TreeNode(nums[start]);
            // 有两个或以上个元素时，选一个中点，分别递归生成左子树和又子树
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = getBST(nums, start, mid);
            root.right = getBST(nums, mid + 1, end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}