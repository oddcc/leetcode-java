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
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            int max = 0;
            int buy = 0;
            int sell = 1;
            // 先找买入位置buy，再找卖出位置sell；如果buy和sell都到末尾了，过程结束
            // 正常情况是sell先到末尾，但在整个都是降序的时候，buy会先到末尾，因为并不能找到一个合适的买入时机
            while (buy < prices.length && sell < prices.length) {
                // 如果buy>= sell说明sell处买入是更好的选择，所以buy指向这里，sell++
                if (prices[buy] >= prices[sell]) {
                    buy = sell;
                    sell++;
                }
                // 如果 buy < sell说明buy买入，sell卖出有的赚，所以算一下利润，如果比最大值更大，就记下来，sell继续++
                else {
                    int sub = prices[sell] - prices[buy];
                    if (sub > max) {
                        max = sub;
                    }
                    sell++;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}