// 59

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(1)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(20)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 生成的矩阵一定是个正方形的
        // 思路1，按圈一圈一圈生成，用0表示还没填数，以右->下->左->上的顺序来填充，如果碰到边界或已填过的数，就转向
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int direction = 1; // 1-向右 2-向下 3-向左 4-向上；一定是先向右遍历
            int x = 0;
            int y = 0;
            for (int i = 1; i <= n * n; i++) {
                ans[x][y] = i;
                if (direction == 1) {
                    if (valid(ans, n, x, y + 1)) {
                        y++;
                    }
                    else {
                        direction = 2;
                        x++;
                    }
                }
                else if (direction == 2) {
                    if (valid(ans, n, x + 1, y)) {
                        x++;
                    }
                    else {
                        direction = 3;
                        y--;
                    }
                }
                else if (direction == 3) {
                    if (valid(ans, n, x, y - 1)) {
                        y--;
                    }
                    else {
                        direction = 4;
                        x--;
                    }
                }
                else {
                    if (valid(ans, n, x - 1, y)) {
                        x--;
                    }
                    else {
                        direction = 1;
                        y++;
                    }
                }
            }

            return ans;
        }

        private boolean valid(int[][] ans, int n, int x, int y) {
            return (x >= 0 && x < n && y >= 0 && y < n && ans[x][y] == 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}