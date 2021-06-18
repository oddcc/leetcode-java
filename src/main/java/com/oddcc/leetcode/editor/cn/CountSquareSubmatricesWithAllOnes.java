// 1277

package com.oddcc.leetcode.editor.cn;

public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        Solution solution = new CountSquareSubmatricesWithAllOnes().new Solution();
        System.out.println(solution.countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
        System.out.println(solution.countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.countSquares(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 1, 0}, {1, 1, 1}, {1, 1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，遍历
    // 提前计算pre[i][j]数组，pre[i][j]表示(0,0)到(i-1,j-1)的矩形中1的个数
    // 从而我们可以以O(1)的时间复杂度来计算任意矩形中1的个数，通过预期和实际1的个数比较，可以验证是不是一个square
    // 在遍历过程中，对每个右下角的点来说，生成的square只会被计算1次
    // 思路2，动态规划
    class Solution {
        public int countSquares(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = 0;
            // dp[i][j]表示以(i,j)为右下角的square的最大边长
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int l1 = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                    int l2 = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    int l3 = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    if (matrix[i][j] == 1) {
                        dp[i][j] = Math.min(Math.min(l1, l2), l3) + 1;
                    }
                    ans += dp[i][j];
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}