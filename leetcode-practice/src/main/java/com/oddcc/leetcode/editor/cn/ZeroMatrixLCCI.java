// 面试题 01.08

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroMatrixLCCI {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLCCI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0){
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }
            for (Integer r: rows) {
                Arrays.fill(matrix[r], 0);
            }
            for (Integer c: cols) {
                for (int i = 0; i < m; i++) {
                    matrix[i][c] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}