// 300

package com.oddcc.leetcode.editor.cn;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(solution.lengthOfLIS(new int[]{7}));
        System.out.println(solution.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，求极值，不要求中间结果，考虑动态规划；
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int[] dp = new int[len]; // dp[i] 表示选择第i个数时，最大的递增子序列是什么
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                // 如果要选择nums[i]，就说明在之前的递增子序列中最后一个数一定是小于nums[i]的
                // 所以我们挑所有符合条件之中最大的
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (dp[j] > max) max = dp[j];
                    }
                }
                dp[i] = max + 1;
            }
            int ans = 0;
            for (int i : dp) {
                if (i > ans) ans = i;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}