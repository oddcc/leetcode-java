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
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
//        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
//        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
//        System.out.println(solution.searchInsert(new int[]{1,3,5,6,7}, 8));
//        System.out.println(solution.searchInsert(new int[]{1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0) return 0;
            return search(nums, target, 0, nums.length - 1);
        }

        // 二分查找，如果找到就返回对应的位置，找不到就返回结束位置+1
        private int search(int[] nums, int target, int start, int end) {
            if (end <= start) {
                if (nums[end] >= target) {
                    return end;
                } else {
                    return end + 1;
                }
            }
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                return search(nums, target, start, mid);
            } else {
                return search(nums, target, mid + 1, end);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}