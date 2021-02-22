// 766

package com.oddcc.leetcode.editor.cn;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        Solution solution = new ToeplitzMatrix().new Solution();
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，遍历二维数组，找到不合法的则返回false
        public boolean isToeplitzMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                if (i == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (j == n - 1) continue;
                    if (matrix[i - 1][j] != matrix[i][j + 1]) return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}