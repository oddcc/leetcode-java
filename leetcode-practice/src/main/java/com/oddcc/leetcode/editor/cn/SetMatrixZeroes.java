// 73

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        solution.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        solution.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
        solution.setZeroes(new int[][]{{1,0}});
        solution.setZeroes(new int[][]{{1},{0},{3}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目要求最好是O(1)的空间复杂度
        // 思路1，遍历两次，第一次记录0的坐标，第二次根据已记录的0的坐标，把对应的位置置为0，空间复杂度O(mn)
        // 思路2，还是两次遍历，只不过对第一次的结果进行剪枝，已经确定标记为0的行或列就不用再遍历了，存储时也只要存储要置为0的行和列就可以，空间复杂度O(m+n)
        // 思路3，优化思路2，利用每行、每列的头一个元素存储是否要置0，但要注意置0的顺序
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean row0Flag = false;
            boolean col0Flag = false;
            // 第一行是否有零
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    row0Flag = true;
                    break;
                }
            }
            // 第一列是否有零
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    col0Flag = true;
                    break;
                }
            }
            // 把第一行第一列作为标志位
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            // 置0
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row0Flag) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }
            if (col0Flag) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }

            System.out.println(Arrays.deepToString(matrix));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}