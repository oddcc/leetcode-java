// 53

package com.oddcc.leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{0}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-2147483647}));
        System.out.println(solution.maxSubArray(new int[]{8, -19, 5, -4, 20}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            // 如果一个 subarray 的和 <= 0 那么对于之后的元素来说，是没有贡献的，可以抛弃
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = nums[i] + sum;
                if (sum > maxSum) {
                    maxSum = sum;
                }
                // sum是非正数，算上sum最终结果也不会更大，就可以把sum归零，意味着i及之前的都抛弃了，从之后的元素重新计算
                if (sum <= 0) {
                    sum = 0;
                }
            }
            return maxSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}