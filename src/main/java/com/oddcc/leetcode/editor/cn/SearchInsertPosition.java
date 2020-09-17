//Given a sorted array and a target value, return the index if the target is fou
//nd. If not, return the index where it would be if it were inserted in order. 
//
// You may assume no duplicates in the array. 
//
// Example 1: 
//
// 
//Input: [1,3,5,6], 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [1,3,5,6], 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: [1,3,5,6], 7
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: [1,3,5,6], 0
//Output: 0
// 
// Related Topics 数组 二分查找 
// 👍 685 👎 0


package com.oddcc.leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7)); // 4
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 0)); // 0
        System.out.println(solution.searchInsert(new int[]{1,3,5,6,7}, 8)); // 5
        System.out.println(solution.searchInsert(new int[]{1}, 1)); // 0
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (nums[left] < target) left++;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}