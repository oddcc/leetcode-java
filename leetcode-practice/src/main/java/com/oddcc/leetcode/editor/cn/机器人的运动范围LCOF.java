// 面试题13&&ji-qi-ren-de-yun-dong-fan-wei-lcof

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 机器人的运动范围LCOF {
    public static void main(String[] args) {
        Solution solution = new 机器人的运动范围LCOF().new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(solution.movingCount(3, 1, 0));
        System.out.println(solution.movingCount(11, 8, 16));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，可以想像成染色的过程，使用bfs来遍历整个二维数组
        public int movingCount(int m, int n, int k) {
            int[][] matrix = new int[m][n]; // 0-没遍历，1-已访问，2-不能访问

            List<int[]> nodes = new ArrayList<>();
            nodes.add(new int[]{0, 0});
            while (!nodes.isEmpty()) {
                List<int[]> options = new ArrayList<>();
                for (int[] node : nodes) {
                    int x = node[0];
                    int y = node[1];
                    if (!valid(x, y, matrix)) {
                        continue;
                    }
                    if (matrix[x][y] == 1 || matrix[x][y] == 2) {
                        continue;
                    }
                    if (canVisit(x, y, k)) {
                        matrix[x][y] = 1;
                        options.add(new int[]{x, y - 1});
                        options.add(new int[]{x - 1, y});
                        options.add(new int[]{x, y + 1});
                        options.add(new int[]{x + 1, y});
                    } else {
                        matrix[x][y] = 2;
                    }
                }
                nodes = options;
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) ans++;
                }
            }
            return ans;
        }

        // 判断x和y的数位之和是否小于等于k
        private boolean canVisit(int x, int y, int k) {
            int total = 0;
            while (x > 0) {
                total += x % 10;
                x /= 10;
            }
            while (y > 0) {
                total += y % 10;
                y /= 10;
            }
            return total <= k;
        }

        // 判断是否越界
        private boolean valid(int x, int y, int[][] matrix) {
            return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}