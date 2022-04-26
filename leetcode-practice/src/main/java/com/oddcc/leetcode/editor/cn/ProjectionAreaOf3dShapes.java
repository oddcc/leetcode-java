// 883

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class ProjectionAreaOf3dShapes {
    public static void main(String[] args) {
        Solution solution = new ProjectionAreaOf3dShapes().new Solution();
        System.out.println(solution.projectionArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(solution.projectionArea(new int[][]{{2}}));
        System.out.println(solution.projectionArea(new int[][]{{1, 0}, {0, 2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int projectionArea(int[][] grid) {
            int n = grid.length;
            int ans = 0;
            int[] xMax = new int[n];
            int[] yMax = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int c = grid[i][j];
                    if (c != 0) {
                        ans++;
                    }
                    if (c > xMax[i]) {
                        xMax[i] = c;
                    }
                    if (c > yMax[j]) {
                        yMax[j] = c;
                    }
                }
            }
            ans += Arrays.stream(xMax).sum();
            ans += Arrays.stream(yMax).sum();
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}