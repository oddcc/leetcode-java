// 1143

package com.oddcc.leetcode.editor.cn;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solution.longestCommonSubsequence("abc", "abc"));
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
        System.out.println(solution.longestCommonSubsequence("bl", "yby"));
        System.out.println(solution.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，只要最终结果，不要过程，考虑动态规划
        // dp[i][j]表示text1到i的位置，和text2到j的位置为止最大的匹配长度
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            int[][] dp = new int[len1][len2];
            if (text1.charAt(0) == text2.charAt(0)) dp[0][0] = 1; // 设置初始值
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (i == 0 && j == 0) continue; // 跳过已知的初始值
                    // 如果text1[i]和text2[j]相同，则说明最大长度应该为dp[i-1][j-1] + 1，因为i和j在这一位上匹配，所以+1
                    // 这里是为了处理越界的情况
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = (valid(i - 1, len1) && valid(j - 1, len2)) ? dp[i - 1][j - 1] + 1 : 1;
                    }
                    // 如果text1[i]和text2[j]不同，则有两种情况，取最大的，dp[i][j]应该是max(dp[i-1][j], dp[i][j-1])
                    // 即i和j在这一位上不匹配，所以取之前两种可能结果的最大值
                    // 同样也是为了处理越界的情况
                    else {
                        dp[i][j] = Math.max((valid(i - 1, len1) && valid(j, len2)) ? dp[i - 1][j] : 0, (valid(i, len1) && valid(j - 1, len2)) ? dp[i][j - 1] : 0);
                    }
                }
            }
            return dp[len1 - 1][len2 - 1];
        }

        private boolean valid(int i, int len) {
            return i >= 0 && i < len;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}