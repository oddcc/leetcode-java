// 918

package com.oddcc.leetcode.editor.cn;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{-3, -2, -3}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{-2}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{9,-4,-7,9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // #1 make i is the start of a circular array, this gives us numbs.length arrays
        // #2 if subarray is divided into 2 parts, then maxSum == total - minSum
        public int maxSubarraySumCircular(int[] nums) {
            int l = nums.length;
            if (l == 1) return nums[0];
            int[] maxSum = new int[l];
            int[] minSum = new int[l];
            int total = 0;
            Integer max = null;
            Integer min = null;
            for (int i = 0; i < l; i++) {
                total += nums[i];
                if (i == 0) {
                    maxSum[i] = nums[i];
                    minSum[i] = nums[i];
                } else {
                    maxSum[i] = Math.max(nums[i], maxSum[i - 1] + nums[i]);
                    minSum[i] = Math.min(nums[i], minSum[i - 1] + nums[i]);
                }
                if (max == null) {
                    max = nums[i];
                } else {
                    max = Math.max(max, maxSum[i]);
                }
                if (min == null) {
                    min = nums[i];
                } else {
                    min = Math.min(min, minSum[i]);
                }
            }
            return total == min ? max : Math.max(max, total - min);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}