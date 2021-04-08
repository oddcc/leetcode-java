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
            int p0, p1;
            if (s.charAt(0) == '0') {
                p0 = 0;
                p1 = 1;
            }
            else {
                p0 = 1;
                p1 = 0;
            }
            int c0 = p0, c1 = p1;
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == '0') {
                    c0 = p1;
                    c1 = p0 + 1;
                }
                else {
                    c0 = p1 + 1;
                    c1 = p0;
                }
                p0 = c0;
                p1 = c1;
            }
            return Math.min(c0, c1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}