// 200
package com.oddcc.leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] n1 = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(solution.numIslands(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        public int numIslands(char[][] grid) {
            int[][] used = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // 没遍历过，且是陆地的，说明是新的一块陆地，则count++
                    if (used[i][j] == 0 && grid[i][j] != '0') {
                        count++;
                        dfs(grid, i, j, used);
                    }
                }
            }
            return count;
        }

        // 从[i,j]位置深度遍历grid
        private void dfs(char[][] grid, int i, int j, int[][] used) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return; // 越界则返回
            if (grid[i][j] == '0') return; // 遇到海面则返回
            if (used[i][j] == 1) return; // 遇到遍历过的则返回
            if (grid[i][j] == '1') {
                used[i][j] = 1;
            }
            dfs(grid, i - 1, j, used); // 左
            dfs(grid, i + 1, j, used); // 右
            dfs(grid, i, j - 1, used); // 上
            dfs(grid, i, j + 1, used); // 下
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}