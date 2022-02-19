// 132

package com.oddcc.leetcode.editor.cn;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        System.out.println(solution.minCut("aab"));
        System.out.println(solution.minCut("a"));
        System.out.println(solution.minCut("ab"));
        System.out.println(solution.minCut("ababababababababababababcbabababababababababababa"));
        System.out.println(solution.minCut("abbab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历+回溯，就是在131的基础上加上计数，在所有答案中取最短的
        // 思路2，优化思路1，使用动态规划，避免重复计算
        // 思路3，只要最终结果，不要过程，考虑动态规划？
        // dp[i]表示[0...i]的最小分割次数
        // dp[i]有两种可能，当第i个元素自己分割出来时，dp[i] = dp[i - 1] + 1
        // 当第i个元素跟前面第j个元素共同构成回文时，dp[i] = dp[j - 1] + 1
        // dp[i] = min(dp[i - 1] + 1, dp[j - 1] + 1)
        // 其中[j...i]组成回文的情况，有多种，我们必须逐一判断
        public int minCut(String s) {
            int len = s.length();
            // 动态规划，cache[i][j]表示[i...j]是不是回文 0-不知道 1-是 2-不是
            // cache[i][j] == 1时，根据回文的定义，要满足cache[i + 1][j - 1] == true && s[i] == s[j]
            int[][] cache = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    calcCache(s, cache, i, j);
                }
            }
            int[] dp = new int[len];
            dp[0] = 0;
            for (int i = 1; i < len; i++) {
                // [0...i]是回文
                if (cache[0][i] == 1) {
                    dp[i] = 0;
                    continue;
                }
                int c = Integer.MAX_VALUE;
                // i单独是一部分
                c = Math.min(c, dp[i - 1] + 1);
                for (int j = 1; j < i; j++) {
                    // [j...i]组成回文
                    if (cache[j][i] == 1) {
                        c = Math.min(c, dp[j - 1] + 1);
                    }
                }
                dp[i] = c;
            }
            return dp[len - 1];
        }

        private void calcCache(String s, int[][] cache, int i, int j) {
            if (i < 0 || i >= cache.length || j < 0 || j >= cache.length) return;
            if (cache[i][j] != 0) return;
            if (i == j) {
                cache[i][j] = 1;
                return;
            }
            // 提前计算要依赖的值
            if (i + 1 <= j - 1) {
                calcCache(s, cache, i + 1, j - 1);
            }
            // Math.abs(i - j) == 1的意思是，两个数挨着，中间没有其他值了，[i...j]肯定是回文
            if (s.charAt(i) == s.charAt(j) && (Math.abs(i - j) == 1 || cache[i + 1][j - 1] == 1)) {
                cache[i][j] = 1;
            }
            else {
                cache[i][j] = 2;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}