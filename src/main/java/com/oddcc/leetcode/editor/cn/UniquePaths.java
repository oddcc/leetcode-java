// 62

package com.oddcc.leetcode.editor.cn;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.uniquePaths(3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，给路径数，不用给出具体路径，考虑动态规划；对于点(m,n)来说，由于只能向右或向下走，如果f(m,n)表示有多少种方法
        // 那么f(m,n)=f(m-1,n)+f(m,n-1)即从上方走和从左侧走
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n]; // 表示有多少种方式到达m,n点
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) continue;
                    int fromUp = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    int fromLeft = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    dp[i][j] = fromUp + fromLeft;
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}