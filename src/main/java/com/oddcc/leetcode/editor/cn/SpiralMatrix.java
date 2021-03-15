// 54

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        System.out.println(solution.spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
        System.out.println(solution.spiralOrder(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        }));
        System.out.println(solution.spiralOrder(new int[][]{
                { 1,  2,  3,  4,  5,  6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接按题意遍历
        public List<Integer> spiralOrder(int[][] matrix) {
            // 直接遍历不方便，采用符合直觉的计数+方向
            int m = matrix.length;
            int n = matrix[0].length;
            int total = m * n;
            List<Integer> ans = new ArrayList<>();
            int direction = 1; // 1-向右 2-向下 3-向左 4-向上；一定是先向右遍历
            int count = 0; // 本圈遍历了几个元素
            int target = 2 * m + 2 * n - 4; // 一圈一圈遍历
            int startX = 0; // 遍历的x起点
            int startY = 0; // 遍历的y起点
            int x = 0;
            int y = 0;
            for (int i = 0; i < total; i++) {
                ans.add(matrix[x][y]);
                count++;
                if (direction == 1) {
                    if (valid(startX, startY, m, n, x, y + 1)) {
                        y++;
                    }
                    else {
                        direction = 2;
                        x++;
                    }
                }
                else if (direction == 2) {
                    if (valid(startX, startY, m, n, x + 1, y)) {
                        x++;
                    }
                    else {
                        direction = 3;
                        y--;
                    }
                }
                else if (direction == 3) {
                    if (valid(startX, startY, m, n, x, y - 1)) {
                        y--;
                    }
                    else {
                        direction = 4;
                        x--;
                    }
                }
                else {
                    if (valid(startX, startY, m, n, x - 1, y) && count < target) {
                        x--;
                    }
                    else {
                        y++;
                        direction = 1;
                        m -= 2;
                        n -= 2;
                        target = 2 * m + 2 * n - 4;
                        count = 0;
                        startX = startX + 1;
                        startY = startY + 1;
                    }
                }
            }
            return ans;
        }

        private boolean valid(int startX, int startY, int m, int n, int x, int y) {
            return (x >= startX && x < startX + m && y >= startY && y < startY + n);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}