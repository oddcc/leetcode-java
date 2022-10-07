// 1800

package com.oddcc.leetcode.editor.cn;

public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MaximumAscendingSubarraySum().new Solution();
        System.out.println(solution.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(solution.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(solution.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
        System.out.println(solution.maxAscendingSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 2, 99}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int res = 0;
            int sum = 0;
            sum += nums[0];
            if (nums.length == 1) {
                return sum;
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    sum += nums[i];
                } else {
                    res = Math.max(res, sum);
                    sum = nums[i];
                }
                if (i == nums.length - 1) {
                    res = Math.max(res, sum);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}