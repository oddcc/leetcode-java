// 剑指 Offer 14- I

package com.oddcc.leetcode.editor.cn;

public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，只要结果，考虑动态规划
        public int cuttingRope(int n) {
            // dp[i][j]表示长度为i的绳子，切为j段时，最大的乘积是多少
            // dp[0][j] = 0，因为长度为0怎么切也是0
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i == j) dp[i][j] = 1; // 长度为i切i段，每段长度为1，积是1
                    else if (j == 1) dp[i][j] = i; // 长度为i切1段，长度就是i，极是i
                    else {
                        // 这里意思是，切一段长度为x的下来，遍历每一种x的可能，取最大的
                        // x * dp[i - x][j - 1] 的意思是这样
                        // 切了一段x，剩下的长度就是i-x，而一共要切j段，长为x的已确定了，剩下要切j-1段
                        for (int x = 1; x <= i; x++) {
                            dp[i][j] = Math.max(dp[i][j], x * dp[i - x][j - 1]);
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 2; i < n + 1; i++) {
                ans = Math.max(ans, dp[n][i]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}