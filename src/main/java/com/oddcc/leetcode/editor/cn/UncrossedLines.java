// 1035

package com.oddcc.leetcode.editor.cn;

import java.util.Map;

public class UncrossedLines {
    public static void main(String[] args) {
        Solution solution = new UncrossedLines().new Solution();
        System.out.println(solution.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(solution.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(solution.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
        System.out.println(solution.maxUncrossedLines(new int[]{3, 1, 4, 1, 1, 3, 5, 1, 2, 2}, new int[]{4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,动态规划
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            // dp[i][j]表示nums1中[0,i]的部分和nums2中[0,j]的部分中，最多能画几条不相交的线
            int[][] dp = new int[m][n];
            // 赋初始值，起点为nums1[0]的时候
            for (int i = 0; i < n; i++) {
                // 当值相同时，可以画一条线，因为起点固定，所以最多也就是一条线
                if (nums1[0] == nums2[i]) dp[0][i] = 1;
                // 当值不同时，虽然当前位置不能作为终点，但之前的位置是可能作为终点的，所以要用之前的值
                else if(i >= 1) dp[0][i] = dp[0][i-1];
            }
            // 起点为nums2[0]的时候，赋初值
            for (int i = 0; i < m; i++) {
                if (nums2[0] == nums1[i]) dp[i][0] = 1;
                else if(i >= 1) dp[i][0] = dp[i-1][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // 值相同时，三种选择，连接i，j两点，不用i点，不用j点
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i][j - 1], dp[i - 1][j]));
                    }
                    // 值不同时，也是三种选择
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
                    }

                }
            }
            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}