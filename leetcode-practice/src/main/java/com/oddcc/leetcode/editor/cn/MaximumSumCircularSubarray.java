// 918

package com.oddcc.leetcode.editor.cn;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{-3, -2, -3}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{-2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // #1 make i is the start of a circular array, this gives us numbs.length arrays
        public int maxSubarraySumCircular(int[] nums) {
            int l = nums.length;
            int[][] sum = new int[l][l];
            Integer ans = null;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    if (j == 0) {
                        sum[i][j] = getNum(nums, i, j);
                    } else {
                        sum[i][j] = Math.max(getNum(nums, i, j), sum[i][j - 1] + getNum(nums, i, j));
                    }

                    if (ans == null) {
                        ans = sum[i][j];
                    } else {
                        ans = Math.max(ans, sum[i][j]);
                    }
                }
            }
            return ans;
        }

        private int getNum(int[] nums, int start, int i) {
            int want = (start + i) % nums.length;
            return nums[want];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}