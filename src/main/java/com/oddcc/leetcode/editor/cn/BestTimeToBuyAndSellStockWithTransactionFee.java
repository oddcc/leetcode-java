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
            int[][] dp = new int[len][2]; // dp[i][0]表示第i天结束时手中没有股票的收益，dp[i][1]表示第i天结束时手中有股票的收益
            dp[0][0] = 0; // 第一天手中没股票，收益为0
            dp[0][1] = -prices[0]; // 第一天手中有股票，收益为负，值是买股票花的钱
            for (int i = 1; i < len; i++) {
                //                  i-1天结束时手里有股票，i天卖出   i-1天手里没有股票，i天什么也没做
                dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
                //                  i-1天手里没股票，i天买入   i-1天手里有股票，i天什么也没做
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}