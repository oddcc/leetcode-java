// 695

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println(solution.maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}}
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，bfs+染色，从(0,0)开始向(m-1,n-1)遍历，当遇到1时，就使用bfs来探查岛的面积，并把探过的地方设为2，记录得到的面积
    // 如果在之后的遍历中遇到2就不再处理，只处理1
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) continue;
                    if (grid[i][j] == 2) continue;
                    Deque<int[]> queue = new LinkedList<>();
                    queue.addFirst(new int[]{i, j});
                    int total = 0;
                    while (!queue.isEmpty()) {
                        for (int c = 0; c < queue.size(); c++) {
                            int[] point = queue.removeLast();
                            int x = point[0];
                            int y = point[1];
                            if (grid[x][y] == 2) continue;
                            total++;
                            grid[x][y] = 2;
                            // up
                            if (x - 1 >= 0 && grid[x - 1][y] == 1) queue.addFirst(new int[]{x - 1, y});
                            // down
                            if (x + 1 < m && grid[x + 1][y] == 1) queue.addFirst(new int[]{x + 1, y});
                            // left
                            if (y - 1 >= 0 && grid[x][y - 1] == 1) queue.addFirst(new int[]{x, y - 1});
                            // right
                            if (y + 1 < n && grid[x][y + 1] == 1) queue.addFirst(new int[]{x, y + 1});
                        }
                    }
                    ans = Math.max(total, ans);
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}