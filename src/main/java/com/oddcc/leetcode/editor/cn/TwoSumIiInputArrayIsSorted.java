//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice. 
// 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 104 
// -1000 <= nums[i] <= 1000 
// nums is sorted in increasing order. 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 407 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] n1 = {2,7,11,15};
        int t1 = 9;
        System.out.println(Arrays.toString(solution.twoSum(n1, t1)));
        int[] n2 = {2,3,4};
        int t2 = 6;
        System.out.println(Arrays.toString(solution.twoSum(n2, t2)));
        int[] n3 = {-1,0};
        int t3 = -1;
        System.out.println(Arrays.toString(solution.twoSum(n3, t3)));
        int[] n4 = {1,2,3,4,4,9,56,90};
        int t4 = 8;
        System.out.println(Arrays.toString(solution.twoSum(n4, t4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划，一个left指针，一个right指针，当sum小于target时，应该左侧指针向右移，当sum大于target时，应该右侧指针向左移动
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) return new int[]{left + 1, right + 1};
                if (sum < target) left++;
                if (sum > target) right--;
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}