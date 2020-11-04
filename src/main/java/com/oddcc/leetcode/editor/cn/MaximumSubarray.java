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
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{0}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-2147483647}));
        System.out.println(solution.maxSubArray(new int[]{8, -19, 5, -4, 20}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划，dp[i]表示以i结尾的和最大的子数组的和
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            int max = dp[0];
            for (int i : dp) {
                if (i > max) max = i;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}