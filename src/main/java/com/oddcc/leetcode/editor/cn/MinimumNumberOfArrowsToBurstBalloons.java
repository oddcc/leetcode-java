// 452

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfArrowsToBurstBalloons().new Solution();
        // System.out.println(solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        // System.out.println(solution.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        // System.out.println(solution.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(solution.findMinArrowShots(new int[][]{}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 先排序，按start从小到大排列，相同的start，按end从小到达排列
        // 从头开始合并区间，合并两个区间的规则是，start取大的，end取小的，如果仍是一个合法区间，则这个区间就是结果
        // 当无法合并时，count+1，因为事先拍过序了，所以之后再不会出现再这个区间内的气球
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            List<int[]> pointsList = new ArrayList<>(Arrays.asList(points));
            pointsList.sort((p1, p2) -> {
                if (p1[0] == p2[0]) return p1[1] - p2[1];
                return p1[0] - p2[0];
            });
            int ans = 0;
            // 从0,1对比到length - 2,length - 1
            for (int i = 0; i < points.length - 1; i++) {
                int[] span = combine(pointsList.get(i), pointsList.get(i + 1));
                if (span[0] == -1) {
                    ans++;
                }
                else {
                    pointsList.set(i + 1, span);
                }
            }
            return ans + 1;
        }

        private int[] combine(int[] i1, int[] i2) {
            int s = Math.max(i1[0], i2[0]);
            int e = Math.min(i1[1], i2[1]);
            if (s <= e) return new int[]{s, e};
            return new int[]{-1, -1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}