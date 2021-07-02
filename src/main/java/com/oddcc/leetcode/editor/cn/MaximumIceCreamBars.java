// 1833

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        Solution solution = new MaximumIceCreamBars().new Solution();
        System.out.println(solution.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(solution.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(solution.maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 背包问题
    // 思路1，动态规划
    // 思路2，优化空间占用，递推时，只用到二维数组的上一行的结果
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            // dp[i][j]表示截至到前i个雪糕，能购买的最大数量
            // 针对此题，costs就是要拿的东西，costs[i]就是每样东西的成本，coins可以理解为背包的容量，每拿一样东西的收益都是1
            // dp[0][j]拿0样物品，dp[i][0]拿i样物品放进容量为0的背包，这两种情况收益都是0，不用额外初始化
            // int[][] dp = new int[costs.length + 1][coins + 1];
            int[] dp = new int[coins + 1];
            for (int i = 1; i < costs.length + 1; i++) {
                int[] last = Arrays.copyOf(dp, coins + 1);
                for (int j = 1; j < coins + 1; j++) {
                    // 对对于第i样物品，对比拿或不拿两种情况
                    dp[j] = Math.max(last[j], j - costs[i - 1] >= 0 ? last[j - costs[i - 1]] + 1 : 0);
                }
            }

            return dp[coins];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}