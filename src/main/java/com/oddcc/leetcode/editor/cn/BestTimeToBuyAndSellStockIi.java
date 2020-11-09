
package com.oddcc.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 多次买卖，最大值；找上升区间，在每个上升区间的start买入，end卖出
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            int start = 0;
            int end = 1;
            int ans = 0;
            // end到结尾时遍历完成
            while (end < prices.length) {
                // 每一趟都尽量把end往后移
                while (end < prices.length && prices[end] > prices[end - 1]) {
                    end++;
                }
                // 不满足时，end - 1指向的是区间的end
                // 只有start<end时才是有效的，如果不满足的end继续后移
                if (start < end) {
                    ans += prices[end - 1] - prices[start];
                    start = end;
                }
                else {
                    end++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}