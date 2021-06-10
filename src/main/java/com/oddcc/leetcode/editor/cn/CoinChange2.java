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
            // dp[i][j] 表示使用i个硬币,凑成j有多少种凑法
            int[][] dp = new int[len + 1][amount + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= len; i++) {
                int coin = coins[i - 1];
                for (int j = 0; j <= amount; j++) {
                    // 当使用到第i个硬币时，有两种情况
                    // dp[i-1][j]表示使用i-1的硬币就可以凑成j，不需要再选第i种硬币
                    // dp[i][j-coin]表示要选这第i种硬币，因为硬币可以重复使用，所以这里第一维是i而不是i-1
                    if (coin > j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                    }
                }
            }
            return dp[len][amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}