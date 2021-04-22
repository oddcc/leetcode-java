// 363

package com.oddcc.leetcode.editor.cn;

public class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
        System.out.println(solution.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        System.out.println(solution.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划，超过内存限制
        // dp[x1][y1][x2][y2]表示左上角(x1,y1)，右下角(x2,y2)的矩形中的元素和（面积）
        // 有 dp[x1][y1][x2][y2] = dp[x1][y1][x2][y2 - 1] + dp[x1][y1][x2 - 1][y2] - dp[x1][y1][x2 - 1][y2 - 1] + matrix[x2][y2]
        // 如果越界了则对应值为0，在计算的过程中取最大，可以得到结果
        // 求值的顺序应该是从左到右、从上到下
        // 思路2，观察可见，实际计算时，x1和y1的值实际上并没有用到，所以我们dp数组可以不要那么大
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = Integer.MIN_VALUE;
            // 计算所有的矩形面积
            for (int x1 = 0; x1 < m; x1++) {
                for (int y1 = 0; y1 < n; y1++) {
                    // 左上角x1,y1
                    int[][] dp = new int[m][n];
                    for (int x2 = x1; x2 < m; x2++) {
                        for (int y2 = y1; y2 < n; y2++) {
                            // 右下角x2,y2
                            int sum = getSum(matrix, dp, x2, y2 - 1)
                                    + getSum(matrix, dp, x2 - 1, y2)
                                    - getSum(matrix, dp, x2 - 1, y2 - 1)
                                    + matrix[x2][y2];
                            dp[x2][y2] = sum;
                            if (sum > k) continue;
                            ans = Math.max(ans, dp[x2][y2]);
                        }
                    }
                }
            }
            // System.out.println(Arrays.deepToString(dp));
            return ans;
        }

        private int getSum(int[][] matrix, int[][] dp, int x2, int y2) {
            int m = matrix.length;
            int n = matrix[0].length;
            if (x2 < 0 || y2 < 0) return 0;
            if (x2 >= m || y2 >= n) return 0;
            return dp[x2][y2];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}