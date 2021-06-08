// 1049

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class LastStoneWeightIi {
    public static void main(String[] args) {
        Solution solution = new LastStoneWeightIi().new Solution();
        System.out.println(solution.lastStoneWeightII(new int[]{1, 2}));
        System.out.println(solution.lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
        System.out.println(solution.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，动态规划
    // 题目可以转换为01背包问题
    // 最终剩余石头最小，可以转化为从所有石头中拿石头，每个石头只能拿最多一次，背包的最大容量是sum/2(sum是所有石头的总重量)
    // 当背包装满时，答案为0
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int len = stones.length;
            int sum = Arrays.stream(stones).sum();
            // dp[i][j]表示第i块石头选完后，装容量为j的背包的实际装的最大重量
            int[][] dp = new int[len + 1][sum / 2 + 1];
            for (int i = 1; i < len + 1; i++) {
                for (int j = 0; j < sum / 2 + 1; j++) {
                    // 这里主要是j - stones[i - 1] >= 0 要成立
                    // 可以理解为限定了j的范围，超出范围的j是没有意义的
                    if (j >= stones[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                    }
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return Math.abs(sum - dp[len][sum / 2] - dp[len][sum / 2]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}