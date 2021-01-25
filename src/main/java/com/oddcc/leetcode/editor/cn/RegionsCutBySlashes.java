// 959

package com.oddcc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class RegionsCutBySlashes {
    public static void main(String[] args) {
        Solution solution = new RegionsCutBySlashes().new Solution();
        System.out.println(solution.regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(solution.regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(solution.regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(solution.regionsBySlashes(new String[]{"/\\", "\\/"}));
        System.out.println(solution.regionsBySlashes(new String[]{"//", "/ "}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，1*1的grid转化成3*3的矩阵，划线的地方标记为1，其余标记为0，问题转化为求有多少个岛
        // 在矩阵中求有多少个岛的问题可以用染色+dfs/bfs来解决
        public int regionsBySlashes(String[] grid) {
            int[][] matrix = convert(grid);
            int ans = 0;
            while (true) {
                int[] start = nextStart(matrix);
                if (start[0] == -1) break;
                bfs(start, matrix);
                ans++;
            }
            return ans;
        }

        private int[][] convert(String[] grid) {
            int[][] matrix = new int[grid.length * 3][grid.length * 3];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length(); j++) {
                    if (grid[i].charAt(j) == ' ') continue;
                    if (grid[i].charAt(j) == '/') {
                        matrix[i * 3][j * 3 + 2] = 1;
                        matrix[i * 3 + 1][j * 3 + 1] = 1;
                        matrix[i * 3 + 2][j * 3] = 1;
                    }
                    if (grid[i].charAt(j) == '\\') {
                        matrix[i * 3][j * 3] = 1;
                        matrix[i * 3 + 1][j * 3 + 1] = 1;
                        matrix[i * 3 + 2][j * 3 + 2] = 1;
                    }
                }
            }
            return matrix;
        }

        // 通过bfs进行搜索，并染色为2表示访问过
        private void bfs(int[] start, int[][] matrix) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                int[] s = queue.remove();
                int i = s[0];
                int j = s[1];
                matrix[i][j] = 2;
                if (getValue(i - 1, j, matrix) == 0) queue.add(new int[]{i - 1, j});
                if (getValue(i + 1, j, matrix) == 0) queue.add(new int[]{i + 1, j});
                if (getValue(i, j - 1, matrix) == 0) queue.add(new int[]{i, j - 1});
                if (getValue(i, j + 1, matrix) == 0) queue.add(new int[]{i, j + 1});
            }
        }

        private int getValue(int i, int j, int[][] matrix) {
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
                return matrix[i][j];
            }
            return 1;
        }

        // 在矩阵中找第一个出现的0的位置，如果没有则返回[-1,-1]
        private int[] nextStart(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) return new int[]{i, j};
                }
            }
            return new int[]{-1, -1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}