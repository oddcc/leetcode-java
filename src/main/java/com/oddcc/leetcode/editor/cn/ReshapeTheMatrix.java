// 566

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        Solution solution = new ReshapeTheMatrix().new Solution();
        System.out.println(Arrays.deepToString(solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接模拟
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int total = nums.length * nums[0].length;
            if (total != r * c) return nums;
            int[][] ans = new int[r][c];
            int x = 0;
            int y = 0;
            for (int[] num : nums) {
                for (int j = 0; j < nums[0].length; j++) {
                    ans[x][y++] = num[j];
                    if (y == c) {
                        y = 0;
                        x++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}