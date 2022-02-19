// 213

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[]{2, 3, 2}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{0}));
        System.out.println(solution.rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，回溯法找最大值，会超时
        // 思路2，动态规划，dp[i][0]表示没选i的最大值，dp[i][1]表示选了i的最大值
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) return nums[0];
            int[][] dp = new int[len][2];
            // 没选第一家的情况
            dp[0][0] = 0;
            dp[0][1] = 0;
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            int ans = Math.max(dp[len - 1][0], dp[len - 1][1]);
            // 选了第一家的情况
            for (int[] arr : dp) Arrays.fill(arr, 0);
            dp[1][0] = nums[0];
            dp[1][1] = nums[0];
            for (int i = 2; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            // 选了第一家的时候，只有不选最后一个，才是答案
            return Math.max(ans, dp[len - 1][0]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}