// 1030

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MatrixCellsInDistanceOrder {
    public static void main(String[] args) {
        Solution solution = new MatrixCellsInDistanceOrder().new Solution();
        // System.out.println(solution.allCellsDistOrder(1, 2, 0, 0));
        System.out.println(solution.allCellsDistOrder(2, 2, 0, 1));
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，构建所有点的数组，自定义排序
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            List<int[]> ansList = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    ansList.add(new int[]{i, j});
                }
            }
            ansList.sort((p1, p2) -> {
                int d1 = Math.abs(p1[0] - r0) + Math.abs(p1[1] - c0);
                int d2 = Math.abs(p2[0] - r0) + Math.abs(p2[1] - c0);
                return d1 - d2;
            });
            int[][] ans = new int[ansList.size()][2];
            for (int i = 0; i < ansList.size(); i++) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}