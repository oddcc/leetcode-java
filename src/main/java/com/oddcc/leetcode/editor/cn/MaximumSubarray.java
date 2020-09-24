//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: nums = [-1]
//Output: -1
// 
//
// Example 5: 
//
// 
//Input: nums = [-2147483647]
//Output: -2147483647
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 分治算法 动态规划 
// 👍 2463 👎 0


package com.oddcc.leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{0}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-2147483647}));
        System.out.println(solution.maxSubArray(new int[]{8,-19,5,-4,20}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            // 如果一个数 <= 0 那么对最大和是没有贡献的，可以抛弃
            // 如果一个 subarray 的和 <= 0 那么对于之后的元素来说，也是没有贡献的，可以抛弃
            // 如果nums中都是 <= 0 的，则返回最大的值就可以
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = nums[i] + sum;
                if (sum > maxSum) {
                    maxSum = sum;
                }
                // 如果当前数没贡献，当前和也没贡献，就可以把sum归零，i及之前的都可以抛弃了，从之后的元素重新计算
                if (nums[i] <= 0 && sum <= 0) {
                    sum = 0;
                }
            }
            return maxSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}