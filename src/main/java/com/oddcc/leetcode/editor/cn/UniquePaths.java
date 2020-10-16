package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划
        public int uniquePaths(int m, int n) {
            int[][] db = new int[m][n]; // 记录了走到从0,0走到m,n有多少种走法
            for (int[] i : db) {
                Arrays.fill(i, -1);
            }
            return getWays(m, n, m - 1, n - 1, db);
        }

        private int getWays(int m, int n, int x, int y, int[][] db) {
            if (x == 0 && y == 0) return 1; // 0,0走到0,0返回1
            if (x > m || x < 0 || y > n || y < 0) return 0; // 超出范围返回0
            int left; // 走到左边的位置有几种走法
            int up; // 走到上边的位置有几种走法
            if (x - 1 >= 0) {
                if (db[x - 1][y] == -1) {
                    left = getWays(m, n, x - 1, y, db);
                    db[x - 1][y] = left;
                }
                else {
                    left = db[x - 1][y];
                }
            }
            else {
                left = 0;
            }

            if (y - 1 >= 0) {
                if (db[x][y - 1] == -1) {
                    up = getWays(m, n, x, y - 1, db);
                    db[x][y - 1] = up;
                }
                else {
                    up = db[x][y - 1];
                }
            }
            else {
                up = 0;
            }

            return left + up;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}