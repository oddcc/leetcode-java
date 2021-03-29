// 1211


package com.oddcc.leetcode.editor.cn;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{}));
        System.out.println(solution.maxProfit(new int[]{1}));
        System.out.println(solution.maxProfit(new int[]{1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，题意可以概括成，左边小，右边大，求最大的差值
        // 思路2，动态规划，dp[i]表示当第i天结束时，获得的最大收益
        // 思路3，另一种动态规划，dp[i][0]表示第i天结束时，手上没股票的最大收益，dp[i][1]表示手上有股票的最大收益
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len <= 1) {
                return 0;
            }
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < len; i++) {
                // 没股票，可能是之前就没买，也可能是当天卖掉了
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 有股票，可能是之前就有，也可能是当前买了，当前买了股票为什么是-prices[i]而不是dp[i-1][0]-prices[i]?
                // 因为题目要求只买卖一次
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[len - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}