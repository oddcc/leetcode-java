// 664

package com.oddcc.leetcode.editor.cn;

public class StrangePrinter {
    public static void main(String[] args) {
        Solution solution = new StrangePrinter().new Solution();
        System.out.println(solution.strangePrinter("aaabbb"));
        System.out.println(solution.strangePrinter("aba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,动态规划
    class Solution {
        public int strangePrinter(String s) {
            int len = s.length();
            // dp[i][j]表示区间[i,j]需要的最小印刷次数
            int[][] dp = new int[len][len];
            for (int i = len - 1; i >= 0; i--) {
                // 当只有一位要印刷时，次数为1
                dp[i][i] = 1;
                for (int j = i + 1; j < len; j++) {
                    // 当i，j所在字符相同时，总是可以再印刷i的同时印刷j，所以对总的次数没有影响
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    // 当j，j所在字符不同时，i和j一定要分开印刷，这时就有很多种情况，我们遍历每一种情况，取最小的结果
                    else {
                        int min = Integer.MAX_VALUE;
                        // 遍历了所有分开印刷的情况
                        for (int k = i; k < j; k++) {
                            // 这里用到了k，i<=k<j,也就是计算dp[0][1]时，要用到dp[0][0]和dp[1][1]
                            // 计算dp[0][2]时，要用到dp[0][0]、dp[1][2]和dp[0][1]、dp[2][2]
                            // 画图来看，就是在矩阵中，需要当前位置的左边的结果有下边的结果；而且用不到j<i的情况
                            // 所以我们的计算顺序是，从矩阵的右下角开始计算，从下到上，从左到右
                            // 代码逻辑就是i从大到小，j从小到大，这样在计算每个i,j时，所有依赖都已经有了
                            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = min;
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}