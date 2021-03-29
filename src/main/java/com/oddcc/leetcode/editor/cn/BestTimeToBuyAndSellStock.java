//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics 数组 动态规划 
// 👍 1210 👎 0


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
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;
            int[] dp = new int[len];
            dp[0] = 0;
            int minPrice = prices[0];
            for (int i = 1; i < len; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            }
            return dp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}