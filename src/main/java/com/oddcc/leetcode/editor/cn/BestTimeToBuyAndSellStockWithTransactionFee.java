// 714

package com.oddcc.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(solution.maxProfit(new int[]{1, 4, 6, 2, 8, 3, 10, 14}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划
        public int maxProfit(int[] prices, int fee) {
            int len = prices.length;
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}