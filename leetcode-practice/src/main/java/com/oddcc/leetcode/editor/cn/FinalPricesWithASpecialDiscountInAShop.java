// 1475

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args) {
        Solution solution = new FinalPricesWithASpecialDiscountInAShop().new Solution();
        System.out.println(Arrays.toString(solution.finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(solution.finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution.finalPrices(new int[]{10, 1, 1, 6})));
        System.out.println(Arrays.toString(solution.finalPrices(new int[]{4, 7, 1, 9, 4, 8, 8, 9, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] finalPrices(int[] prices) {
            int len = prices.length;
            int[] ans = new int[len];
            // [index, value]
            Deque<int[]> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                if (stack.isEmpty()) {
                    stack.push(new int[]{i, prices[i]});
                    continue;
                }
                Deque<int[]> tmpStack = new LinkedList<>();
                while (stack.peek() != null) {
                    int[] top = stack.peek();
                    if (top[0] != i && top[1] >= prices[i]) {
                        tmpStack.push(new int[]{top[0], top[1] - prices[i]});
                        stack.pop();
                    } else {
                        break;
                    }
                    while (!tmpStack.isEmpty()) {
                        int[] t = tmpStack.pop();
                        ans[t[0]] = t[1];
                    }
                }
                stack.push(new int[]{i, prices[i]});
            }
            while (!stack.isEmpty()) {
                int[] t = stack.removeLast();
                ans[t[0]] = t[1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}