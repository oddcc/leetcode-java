// 1277

package com.oddcc.leetcode.editor.cn;

public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        Solution solution = new CountSquareSubmatricesWithAllOnes().new Solution();
        System.out.println(solution.countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
        System.out.println(solution.countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，遍历
    // 提前计算pre[i][j]数组，pre[i][j]表示(0,0)到(i-1,j-1)的矩形中1的个数
    // 从而我们可以以O(1)的时间复杂度来计算任意矩形中1的个数，通过预期和实际1的个数比较，可以验证是不是一个square
    // 在遍历过程中，对每个右下角的点来说，生成的square只会被计算1次
    class Solution {
        public int countSquares(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] pre = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 左上
                    int sum1 = i - 1 >= 0 && j - 1 >= 0 ? pre[i - 1][j - 1] : 0;
                    // 上方
                    int sum2 = i - 1 >= 0 ? pre[i - 1][j] : 0;
                    // 左方
                    int sum3 = j - 1 >= 0 ? pre[i][j - 1] : 0;

                    pre[i][j] += sum2 + sum3 - sum1 + matrix[i][j];
                }
            }
            return count(pre, matrix);
        }

        private int count(int[][] pre, int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) continue;
                    for (int x = 0; x <= Math.min(i, j); x++) {
                        int edgeLen = x + 1;
                        int shouldHave = edgeLen * edgeLen;
                        if (shouldHave == compute(pre, matrix, i, j, x)) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }

        private int compute(int[][] pre, int[][] matrix, int i, int j, int x) {
            if (x == 0) return matrix[i][j];
            int x1 = i - x;
            int y1 = j - x;
            int sum1 = x1 - 1 >= 0 && y1 - 1 >= 0 ? pre[x1 - 1][y1 - 1] : 0;
            int sum2 = x1 - 1 >= 0 ? pre[x1 - 1][j] : 0;
            int sum3 = y1 - 1 >= 0 ? pre[i][y1 - 1] : 0;
            return pre[i][j] - sum2 - sum3 + sum1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}