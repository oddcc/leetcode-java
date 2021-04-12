// 343

package com.oddcc.leetcode.editor.cn;

public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        System.out.println(solution.integerBreak(2));
        System.out.println(solution.integerBreak(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，考虑动态规划，dp[i]为数字i拆分后的最大乘积
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                // j表示最新拆分出来的数字
                for (int j = 1; j < i; j++) {
                    // j * dp[i - j]表示剩余的i-j还会被拆分
                    // j * (i - j)表示剩余的i-j不会被拆分
                    dp[i] = Math.max(dp[i], Math.max(i - j >= 2 ? j * dp[i - j] : 0, j * (i - j)));
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}