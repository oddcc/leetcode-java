// 97

package com.oddcc.leetcode.editor.cn;

public class InterleavingString {
    public static void main(String[] args) {
        Solution solution = new InterleavingString().new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave("", "", ""));
        System.out.println(solution.isInterleave("ab", "bc", "bcab"));
        System.out.println(solution.isInterleave("", "", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 条件|n-m|<=1说的就是s1和s2必须交叉选择
    // 思路1，递归，超时
    // 思路2，动态规划
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int l1 = s1.length();
            int l2 = s2.length();
            if (l1 + l2 != s3.length()) return false;
            // dp[i1][i2]表示截至s1的前i1个字符，s2的前i2个字符，是否能构成s3的前i1+i2个字符
            boolean[][] dp = new boolean[l1 + 1][l2 + 1];
            dp[0][0] = true;
            for (int i1 = 1; i1 <= l1; i1++) {
                if (s1.charAt(i1 - 1) == s3.charAt(i1 - 1)) {
                    dp[i1][0] |= dp[i1 - 1][0];
                }
            }
            for (int i2 = 1; i2 <= l2; i2++) {
                if (s2.charAt(i2 - 1) == s3.charAt(i2 - 1)) {
                    dp[0][i2] |= dp[0][i2 - 1];
                }
            }
            for (int i1 = 1; i1 <= l1; i1++) {
                for (int i2 = 1; i2 <= l2; i2++) {
                    // 如果s1的第i1个字符跟s3的第i1+i2个字符相同
                    // 则如果s1的前i1-1个字符和s2的前i2个字符可以构成s3的前i1-1+i2个字符的话，就可以构成
                    if (s1.charAt(i1 - 1) == s3.charAt(i1 + i2 - 1)) {
                        dp[i1][i2] |= dp[i1 - 1][i2];
                    }
                    // s2的第i2个字符跟s3的第i1+i2个字符相同
                    if (s2.charAt(i2 - 1) == s3.charAt(i1 + i2 - 1)) {
                        dp[i1][i2] |= dp[i1][i2 - 1];
                    }
                }
            }

            return dp[l1][l2];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}