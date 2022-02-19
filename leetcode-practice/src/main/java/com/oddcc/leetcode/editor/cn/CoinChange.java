// 322

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
        System.out.println(solution.coinChange(new int[]{1}, 1));
        System.out.println(solution.coinChange(new int[]{1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 背包问题？
        // 求极值，不要具体答案，考虑动态规划
        public int coinChange(int[] coins, int amount) {
            int len = coins.length;
            if (len == 0 && amount != 0) return -1;
            // dp[i] 表示要凑成i，最少需要多少硬币，dp[i] == -1说明不存在答案
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i < amount + 1; i++) {
                List<Integer> options = new ArrayList<>();
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        if (dp[i - coins[j]] == -1) continue;
                        options.add(dp[i - coins[j]] + 1);
                    }
                }
                int min = Integer.MAX_VALUE;
                for (int option : options) {
                    if (option != -1 && option < min) min = option;
                }
                dp[i] = min == Integer.MAX_VALUE ? -1 : min;
            }
            return dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}