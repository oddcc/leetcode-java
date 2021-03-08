// 132

package com.oddcc.leetcode.editor.cn;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        System.out.println(solution.minCut("aab"));
        System.out.println(solution.minCut("a"));
        System.out.println(solution.minCut("ab"));
        System.out.println(solution.minCut("ababababababababababababcbabababababababababababa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历+回溯，就是在131的基础上加上计数，在所有答案中取最短的
        // 思路2，优化思路1，使用动态规划，避免重复计算
        private int ans;
        private int[][] dp; // dp[i][j] 0-不知道 1-是回文 2-不是回文

        public int minCut(String s) {
            ans = 2000;
            dp = new int[s.length()][s.length()];
            dfs(s, 0, s.length(), 0);
            return ans;
        }

        private void dfs(String s, int start, int end, int len) {
            if (start >= end) {
                ans = Math.min(ans, len - 1);
                return;
            }
            for (int i = start; i < end; i++) {
                if (!isPalindrome(s, start, i)) {
                    continue;
                }
                len++;
                dfs(s, i + 1, end, len);
                len--;
            }
        }

        private boolean isPalindrome(String s, int l, int r) {
            if (dp[l][r] == 1) return true;
            if (dp[l][r] == 2) return false;
            while (s.charAt(l) == s.charAt(r)) {
                dp[l][r] = 1;
                l++;
                r--;
                if (l >= r) {
                    return true;
                }
            }
            dp[l][r] = 2;
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}