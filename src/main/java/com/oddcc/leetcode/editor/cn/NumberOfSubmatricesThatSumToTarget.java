// 1074

package com.oddcc.leetcode.editor.cn;

public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubmatricesThatSumToTarget().new Solution();
        System.out.println(solution.numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
        System.out.println(solution.numSubmatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0));
        System.out.println(solution.numSubmatrixSumTarget(new int[][]{{904}}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int[][] record = new int[matrix.length + 1][matrix[0].length + 1];
            // 前缀和
            for (int i = 1; i < record.length; ++i) {
                for (int j = 1; j < record[0].length; ++j) {
                    record[i][j] = record[i - 1][j] + record[i][j - 1] - record[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            int res = 0;
            // i,j 右下方边界，k,t 左上方边界。
            for (int i = 1; i < record.length; ++i) {
                for (int j = 1; j < record[0].length; ++j) {
                    for (int k = 0; k < i; ++k) {
                        for (int t = 0; t < j; ++t) {
                            if ((record[i][j] - record[k][j] - record[i][t] + record[k][t]) == target) {
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}