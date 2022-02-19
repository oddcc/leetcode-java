// 221

package com.oddcc.leetcode.editor.cn;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        // System.out.println(solution.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(solution.maximalSquare(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'0', '0', '1', '1', '1'}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 只需要最终结果，考虑动态规划
        // dp[i][j]表示以[i,j]为右下角的最大矩形的面积
        // 经过观察我们可以发现这样的规律
        // 要计算[i,j]位置的最大矩形面积，需要看[i-1,j-1] [i-1,j] [i,j-1]三个点的值
        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int[][] dp = new int[matrix.length][matrix[0].length];
            int ans = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int area = getArea(i, j, matrix, dp);
                    if (area > ans) ans = area;
                }
            }
            return ans;
        }

        private int getArea(int i, int j, char[][] matrix, int[][] dp) {
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
            if (dp[i][j] != 0) return dp[i][j];
            if (matrix[i][j] == '0') return 0;
            int area1 = getArea(i - 1, j - 1, matrix, dp); // 左上
            int area2 = getArea(i - 1, j, matrix, dp); // 上
            int area3 = getArea(i, j - 1, matrix, dp); // 左
            int d = Math.min(Math.min((int) Math.sqrt(area1), (int) Math.sqrt(area2)), (int) Math.sqrt(area3)); // 画图比较清楚
            dp[i][j] = (d + 1) * (d + 1);
            return dp[i][j];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}