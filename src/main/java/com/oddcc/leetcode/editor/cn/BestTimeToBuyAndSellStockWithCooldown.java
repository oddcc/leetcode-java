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
        // 思路1，dp[i][j][z] i天结束时最大收益，j：0-结束时手里没有股票，1-结束时手里有股票，z：0-当天没有交易，1-当天有交易
        // 思路1有个问题，比如 dp[0][0][1] 实际上是不应该有值的，后续状态转移还要判断这个值是不是非法，可能意味着抽象的不太对
        // 思路2，抽象成3种情况 d[i][j]，j：0-结束时手里有股票，1-没股票，不在冷却期，2-没股票，在冷却期
        // 为什么可以抽象成3种？因为有股票的情况下，前一天必定没有经过卖出，因为条件中写了，买卖不能在同一天，所以有股票的情况不受冷却期的限制
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;
            int[][] dp = new int[len][3];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            dp[0][2] = 0;
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
                dp[i][2] = dp[i - 1][0] + prices[i];
            }
            return Math.max(dp[len - 1][0], Math.max(dp[len - 1][1], dp[len - 1][2]));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}