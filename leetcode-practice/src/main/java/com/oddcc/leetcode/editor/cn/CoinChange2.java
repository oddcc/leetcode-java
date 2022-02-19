// 518

package com.oddcc.leetcode.editor.cn;

public class CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change(3, new int[]{2}));
        System.out.println(solution.change(10, new int[]{10}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 每个硬币可以使用多次
    // 思路1，dfs+哈希表
    // 思路2，动态规划
    class Solution {
        public int change(int amount, int[] coins) {
            int len = coins.length;
            // dp[i]表示凑成i一共有多少种凑法
            int[] dp = new int[amount + 1];
            dp[0] = 1; // 只有一个都不选这一种凑法
            for (int coin : coins) {
                // 先选了硬币，然后使用该硬币后凑成的所有值
                for (int j = coin; j < amount + 1; j++) {
                    // 表示dp[j-coin]和coin凑成了j，共有几种凑法
                    dp[j] += dp[j - coin];
                }
            }
            return dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}