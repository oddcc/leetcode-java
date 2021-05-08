// 1723

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FindMinimumTimeToFinishAllJobs {
    public static void main(String[] args) {
        Solution solution = new FindMinimumTimeToFinishAllJobs().new Solution();
        System.out.println(solution.minimumTimeRequired(new int[]{3, 2, 3}, 3));
        System.out.println(solution.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,暴力法,如果jobs.length为n,则每个工作有k种分配方式,时间复杂度为O(n^k),所有答案中取取小值
    // 思路2,动态规划,dp[i][j]表示截至分配到第i个工作时,第i个工作分配给j工人时的最大工时的最小值
    class Solution {
        public int minimumTimeRequired(int[] jobs, int k) {
            int n = jobs.length;
            // dp[i][j1][j2][x]表示截至到第i份工作的分配，第i-1份工作分配给j1，第i份工作分配给j2，此时x的总工时
            int[][][][] dp = new int[n][k][k][k];
            for (int i = 0; i < k; i++) {
                dp[0][i][i][i] = jobs[0];
            }
            // System.out.println(Arrays.deepToString(dp[0]));

            for (int i = 1; i < n; i++) {
                for (int j1 = 0; j1 < k; j1++) {
                    for (int j2 = 0; j2 < k; j2++) {
                        for (int x = 0; x < k; x++) {
                            dp[i][j1][j2][x] = x == j2 ? dp[i - 1][j1][j2][x] + jobs[i] : dp[i - 1][j1][j2][x];
                        }
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int j1 = 0; j1 < k; j1++) {
                for (int j2 = 0; j2 < k; j2++) {
                    int max = 0;
                    for (int x = 0; x < k; x++) {
                        max = Math.max(dp[n - 1][j1][j2][x], max);
                    }
                    ans = Math.min(ans, max);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}