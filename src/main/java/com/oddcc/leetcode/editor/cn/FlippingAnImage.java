// 832

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FlippingAnImage {
    public static void main(String[] args) {
        Solution solution = new FlippingAnImage().new Solution();
        System.out.println(Arrays.deepToString(solution.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));
        System.out.println(Arrays.deepToString(solution.flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接模拟，一次遍历就可以完成修改，时间复杂度O(N)
        public int[][] flipAndInvertImage(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            for (int[] row : A) {
                for (int i = 0; i < n / 2; i++) {
                    int tmp = row[i];
                    row[i] = row[n - 1 - i];
                    row[n - 1 - i] = tmp;
                }
                for (int i = 0; i < n; i++) {
                    if (row[i] == 1) {
                        row[i] = 0;
                    }
                    else {
                        row[i] = 1;
                    }
                }
            }
            return A;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}