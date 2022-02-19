// 647

package com.oddcc.leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("abcb"));
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
        System.out.println(solution.countSubstrings("aaaaa"));
        System.out.println(solution.countSubstrings("aaaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法+动态规划
        // dp[i][j]表示i~j的子串是否是回文串
        // dp[i][j] = s[i] == s[j] && dp[i+1, j-1]；即跟右下角的值相关
        // 由定义能知道dp[i][j] = dp[j][i]
        // 计算的顺序是以左上->右下的对角线为起点，向右上方计算
        public int countSubstrings(String s) {
            int n = s.length();
            int[][] dp = new int[n][n]; // 0表示未知，1表示是回文，2表示不是回文
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (dp[i][j] != 0) continue;
                    if (i == j) {
                        dp[i][j] = 1; // 每个单独的字母都是回文
                        ans++;
                    }
                    // 两个字符的子串，如果字符相同是回文，否则不是回文
                    if (Math.abs(i - j) == 1) {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = 1;
                            ans++;
                        }
                        else {
                            dp[i][j] = 2;
                        }
                    }
                }
            }
            // 对角线为起点向右上方
            for (int i = 0; i < n; i++) {
                int x = i;
                int y = i;
                while (x - 1 >= 0 && y + 1 < n) {
                    if (dp[x - 1][y + 1] != 0) {
                        x--;
                        y++;
                        continue;
                    }
                    if (s.charAt(x - 1) != s.charAt(y + 1)) {
                        dp[x - 1][y + 1] = 2;
                    }
                    else {
                        dp[x - 1][y + 1] = dp[x][y];
                        if (dp[x][y] == 1) ans++;
                    }
                    x--;
                    y++;
                }
            }
            // 以0-1,1-2为起点想右上方计算
            for (int i = 1; i < n; i++) {
                int x = i;
                int y = i + 1;
                while (x - 1 >= 0 && y + 1 < n) {
                    if (dp[x - 1][y + 1] != 0) {
                        x--;
                        y++;
                        continue;
                    }
                    if (s.charAt(x - 1) != s.charAt(y + 1)) {
                        dp[x - 1][y + 1] = 2;
                    }
                    else {
                        dp[x - 1][y + 1] = dp[x][y];
                        if (dp[x][y] == 1) ans++;
                    }
                    x--;
                    y++;
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}