// 746

package com.oddcc.leetcode.editor.cn;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，利用动态规划，计算最小成本
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] dp = new int[len]; // dp[i]表示经过i的最小成本
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < len; i++) {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
            }
            return Math.min(dp[len - 1], dp[len - 2]); // 从最后一个楼梯上，还是从倒数第二个楼梯上
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}