// 64
package com.oddcc.leetcode.editor.cn;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
//        int[][] n1 = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] n1 = new int[][]{{1, 3}, {1, 5}, {4, 2}};
//        int[][] n1 = new int[][]{{1}};
//        int[][] n1 = new int[][]{{9, 1, 4, 8}};
        System.out.println(solution.minPathSum(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 只能向右或向下走，对于最左上的点来说，最小的路径在两种走法之间选择即可；每一次都是选最小的
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length;
            if (n == 0) return 0;
            int[][] db = new int[m][n];
            for (int x = m - 1; x >= 0; x--) {
                if (x == m - 1) {
                    db[x][n - 1] = grid[x][n - 1];
                    continue;
                }
                db[x][n - 1] = grid[x][n - 1] + db[x + 1][n - 1];
            }
            for (int y = n - 1; y >= 0; y--) {
                if (y == n - 1) {
                    db[m - 1][y] = grid[m - 1][y];
                    continue;
                }
                db[m - 1][y] = grid[m - 1][y] + db[m - 1][y + 1];
            }
            for (int x = m - 2; x >= 0; x--) {
                for (int y = n - 2; y >= 0; y--) {
                    db[x][y] = grid[x][y] + Math.min(db[x + 1][y], db[x][y + 1]);
                }
            }
            return db[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}