// 1232

package com.oddcc.leetcode.editor.cn;

public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        Solution solution = new CheckIfItIsAStraightLine().new Solution();
        System.out.println(solution.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println(solution.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println(solution.checkStraightLine(new int[][]{{0, 0}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {7, 7}}));
        System.out.println(solution.checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 斜率相同即表明在一条直线上，如何计算直线的斜率？
        public boolean checkStraightLine(int[][] coordinates) {
            int x1 = coordinates[0][0];
            int y1 = coordinates[0][1];
            int dx = coordinates[1][0] - x1;
            int dy = coordinates[1][1] - y1;
            for (int i = 2; i < coordinates.length; i++) {
                int x = coordinates[i][0];
                int y = coordinates[i][1];
                if ((y - y1) * dx != (x - x1) * dy) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}