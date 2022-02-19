// 474

package com.oddcc.leetcode.editor.cn;

public class OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][][] dp = new int[len + 1][m + 1][n + 1];

            for (int i = 1; i <= len; i++) {
                // 注意：有一位偏移
                int[] count = convert(strs[i - 1]);
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        // 先把上一行抄下来
                        dp[i][j][k] = dp[i - 1][j][k];
                        int zeros = count[0];
                        int ones = count[1];
                        if (j >= zeros && k >= ones) {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                        }
                    }
                }
            }
            return dp[len][m][n];
        }

        private int[] convert(String str) {
            int[] cnt = new int[2];
            for (char c : str.toCharArray()) {
                cnt[c - '0']++;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}