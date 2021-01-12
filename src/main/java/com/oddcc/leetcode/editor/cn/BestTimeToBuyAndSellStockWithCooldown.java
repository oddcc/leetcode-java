// 309

package com.oddcc.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 求极值，不要求中间过程，考虑动态规划
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;
            // dp[i][j][z] i天结束时最大收益 是Integer.MIN_VALUE时表示不可能的情况 todo 这里表示不可能的方式会有问题
            // i：0-结束时手里没有股票，1-结束时手里有股票
            // z：0-当天没有交易，1-当天有交易
            int[][][] dp = new int[len][2][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = Integer.MIN_VALUE;
            dp[0][1][0] = Integer.MIN_VALUE;
            dp[0][1][1] = -prices[0];
            for (int i = 1; i < len; i++) {
                // 当天没有交易，也没有股票 -> 要么前一天也是这样，要么前一天把股票卖了
                dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
                // 当天有交易，没有股票 -> 要么前一天买了股票，要么前一天没买，只是持有
                dp[i][0][1] = Math.max(dp[i - 1][1][1] == Integer.MIN_VALUE ? 0 : (dp[i - 1][1][1] + prices[i]), dp[i - 1][1][0] == Integer.MIN_VALUE ? 0 : (dp[i - 1][1][0] + prices[i]));
                // 当天没交易，有股票 -> 前一天买的，前一天没买，一直持有
                dp[i][1][0] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0]);
                // 当天有交易，有股票 -> 因为有冷却期的限制，只能是前一天没有股票，也没有卖出
                dp[i][1][1] = dp[i - 1][0][0] - prices[i];
            }
            return Math.max(dp[len - 1][0][0], Math.max(dp[len - 1][0][1], Math.max(dp[len - 1][1][0], dp[len - 1][1][1])));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}