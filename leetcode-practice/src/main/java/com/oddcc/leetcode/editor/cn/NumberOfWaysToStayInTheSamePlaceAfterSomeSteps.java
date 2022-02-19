// 1269

package com.oddcc.leetcode.editor.cn;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().new Solution();
        System.out.println(solution.numWays(3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 题目明显符合递归的条件，但复杂度太高
    // 思路1，动态规划
    class Solution {
        public int numWays(int steps, int arrLen) {
            // 一共steps步，每次最多移动一步，所以最远不会超过steps
            int maxColumn = Math.min(arrLen - 1, steps);
            // dp[steps][j]表示走到第steps步时，下标位于j的方案数
            int[][] dp = new int[steps + 1][maxColumn + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= steps; i++) {
                for (int j = 0; j <= maxColumn; j++) {
                    // 第i步没动的情况
                    dp[i][j] = dp[i - 1][j];
                    // 上一步在左边的情况
                    if (j - 1 >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
                    }
                    // 上一步在右边的情况
                    if (j + 1 <= maxColumn) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000007;
                    }
                }
            }
            return dp[steps][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}