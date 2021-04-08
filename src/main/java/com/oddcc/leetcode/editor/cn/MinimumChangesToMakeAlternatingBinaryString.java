// 1758

package com.oddcc.leetcode.editor.cn;

public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        Solution solution = new MinimumChangesToMakeAlternatingBinaryString().new Solution();
        System.out.println(solution.minOperations("0100"));
        System.out.println(solution.minOperations("10"));
        System.out.println(solution.minOperations("1111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，考虑动态规划，dp[i][0]表示以i结尾，结尾是0时，最小次数；dp[i][1]表示以i结尾，结尾是1时，最小次数
        // s[i] == 0时，有
        // dp[i][0] = dp[i-1][1] 当前一位不用变，前一位是1
        // dp[i][1] = dp[i-1][0] + 1 当前一位变成1，前一位是0
        // s[i] == 1时，有
        // dp[i][0] = dp[i-1][1] + 1 当前一位变成0，前一位是1
        // dp[i][1] = dp[i-1][0] 当前一位不用变，前一位是0
        public int minOperations(String s) {
            int len = s.length();
            int[][] dp = new int[len][2];
            if (s.charAt(0) == '0') {
                dp[0][0] = 0;
                dp[0][1] = 1;
            }
            else {
                dp[0][0] = 1;
                dp[0][1] = 0;
            }
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == '0') {
                    dp[i][0] = dp[i - 1][1];
                    dp[i][1] = dp[i - 1][0] + 1;
                }
                else {
                    dp[i][0] = dp[i - 1][1] + 1;
                    dp[i][1] = dp[i - 1][0];
                }
            }
            return Math.min(dp[len - 1][0], dp[len - 1][1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}