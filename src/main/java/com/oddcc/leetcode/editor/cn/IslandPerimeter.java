package com.oddcc.leetcode.editor.cn;

public class IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new IslandPerimeter().new Solution();
        System.out.println(solution.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 直接遍历数组，规律是，遍历时要校验上下左右四个方向是否有相邻的陆地，如果相邻数是n，之前的周长是m，新的周长是m + 4 - 2*n，遍历完成时，返回周长即可
        public int islandPerimeter(int[][] grid) {
            int ans = 0;
            boolean[][] used = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        used[i][j] = true;
                        ans = ans + 4 - 2 * (connectCount(i, j, grid, used));
                    }
                }
            }
            return ans;
        }

        // 返回在grid中，位于i、j的陆地有几个相邻的陆地
        private int connectCount(int i, int j, int[][] grid, boolean[][] used) {
            int total = 0;
            if (valid(i - 1, j, grid) && grid[i - 1][j] == 1 && !used[i - 1][j]) total++; // 上
            if (valid(i + 1, j, grid) && grid[i + 1][j] == 1 && !used[i + 1][j]) total++; // 下
            if (valid(i, j - 1, grid) && grid[i][j - 1] == 1 && !used[i][j - 1]) total++; // 左
            if (valid(i, j + 1, grid) && grid[i][j + 1] == 1 && !used[i][j + 1]) total++; // 右
            return total;
        }

        private boolean valid(int i, int j, int[][] grid) {
            return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}