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
        // 题意可以概括成，左边小，右边大，求最大的差值
        // 先确定买入x，再确定卖出y
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            int max = 0;
            int x = 0;
            int y = 1;
            while (x < prices.length && y < prices.length) {
                if (prices[x] >= prices[y]) {
                    x = y;
                    y++;
                }
                else {
                    int sub = prices[y] - prices[x];
                    if (sub > max) {
                        max = sub;
                    }
                    y++;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}