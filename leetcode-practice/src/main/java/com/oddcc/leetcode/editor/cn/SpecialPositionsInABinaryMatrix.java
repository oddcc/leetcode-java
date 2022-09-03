// 1582

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SpecialPositionsInABinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new SpecialPositionsInABinaryMatrix().new Solution();
        System.out.println(solution.numSpecial(new int[][]{
                {1, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSpecial(int[][] mat) {
            int ans = 0;
            int[] rowCount = new int[mat.length];
            int[] columnCount = new int[mat[0].length];
            Arrays.fill(rowCount, 0);
            Arrays.fill(columnCount, 0);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1) {
                        rowCount[i]++;
                        columnCount[j]++;
                    }
                }
            }

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1 && rowCount[i] == 1 && columnCount[j] == 1) {
                        ans++;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}