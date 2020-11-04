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
        // 思路2，动态规划
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int max = Integer.MIN_VALUE;
            int[] dpMax = new int[len]; // 表示以i结尾的乘积最大的子数组的乘积
            int[] dpMin = new int[len]; // 表示以i结尾的乘积最小的子数组的乘积
            // 给初始值
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            for (int i = 1; i < len; i++) {
                // 当nums[i]<0时，乘负数会得到一个正数，这个负数要尽可能小；乘正数会得到一个负数，这个正数要尽可能大（以备后用）
                if (nums[i] < 0) {
                    dpMax[i] = Math.max(dpMin[i - 1] * nums[i], nums[i]);
                    dpMin[i] = Math.min(dpMax[i - 1] * nums[i], nums[i]);
                }
                // 当nums[i]>=0时，正常计算最大最小值
                else {
                    dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
                    dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
                }
            }
            max = dpMax[0];
            for (int i: dpMax) {
                if (i > max) max = i;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}