//Say you have an array prices for which the ith element is the price of a given
// stock on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (i.e., buy one and sell one share of the stock multiple tim
//es). 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), prof
//it = 6-3 = 3.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 869 👎 0


package com.oddcc.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
//        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 跟121题目类似，但可以多次买卖
        // 每次降低时就是新的买入时机，降低之前就是卖出时机
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            // 记录最终结果
            int result = 0;
            // 每次交易的最大利润
            int maxProfit = 0;
            int buy = 0;
            int sell = 1;
            while (buy < prices.length && sell < prices.length) {
                // 说明sell点更适合买入
                if (prices[buy] >= prices[sell] ||
                        // 说明开始下降了，应该止盈，开始可能的下次交易
                        prices[sell - 1] > prices[sell]) {
                    buy = sell;
                    sell++;
                    result += maxProfit;
                    maxProfit = 0;
                }
                else {
                    int profit = prices[sell] - prices[buy];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                    sell++;
                }
            }
            // 因为每次交易结束时都把maxProfit清零了，如果循环外还有，说明是在最后卖出的，也要算进来
            if (maxProfit != 0) {
                result += maxProfit;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}