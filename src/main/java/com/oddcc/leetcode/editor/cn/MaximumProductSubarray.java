package com.oddcc.leetcode.editor.cn;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(solution.maxProduct(new int[]{2}));
        System.out.println(solution.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(solution.maxProduct(new int[]{5, 30, -3, 4, -3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法+动态规划，对非常大的输入来说是有问题的，空间复杂度是O(N)，提交会内存超限；dp[i][j]表示的是[i,j]区间数组的乘积
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int max = Integer.MIN_VALUE;
            int[][] dp = new int[len][len]; // dp[i][j]记的是区间[i,j]的乘积
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    int product = dps(nums, i, j, dp);
                    if (product > max) max = product;
                }
            }
            return max;
        }

        /**
         * 计算nums中区间[i,j]的乘积
         *
         * @param nums
         * @param i
         * @param j
         * @param dp
         * @return
         */
        private int dps(int[] nums, int i, int j, int[][] dp) {
            if (j <= i) return nums[i]; // 如果区间只包含1个元素，则返回本身
            int product;
            if (dp[i][j] == 0) { // 用==0判断，可能导致重复计算，因为乘积也可能为0，但大多数情况没问题，用0判断比较简单
                product = nums[i] * dps(nums, i + 1, j, dp); // 递推公式
                dp[i][j] = product;
            }
            else {
                product = dp[i][j];
            }
            return product;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}