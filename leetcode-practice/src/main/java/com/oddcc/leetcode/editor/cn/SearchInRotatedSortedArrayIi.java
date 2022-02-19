// 81

package com.oddcc.leetcode.editor.cn;

public class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println(solution.search(new int[]{1}, 0));
        System.out.println(solution.search(new int[]{1, 1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，一次遍历+两次二分查找，先遍历一次，找到数组pivot，然后分成两个有序的子数组进行二分查找；O(N)复杂度，极端情况下甚至不如直接遍历来的快，肯定是不行的
        // 思路2，二分法的时候，找到中点mid
        // 如果有nums[mid] < nums[end]，那么可以判断[mid, end]这个区间是有序的，相应的[start, mid-1]这个区间就是无序的
        // 如果有nums[mid] > nums[end]，那么可以判断[start, mid]这个区间是有序的，对应的[mid + 1, end]这个区间就是无序的
        // 但因为题意允许有重复的数字，所有可能有nums[mid] == nums[end]的情况，这时候无法判断哪边是有序的
        // 但我们能知道nums[mid]不是答案，所以可以跳过mid和end两个元素，继续查找
        public boolean search(int[] nums, int target) {
            return search(nums, 0, nums.length - 1, target);
        }

        private boolean search(int[] nums, int start, int end, int target) {
            if (end <= start) {
                return nums[start] == target;
            }
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[end]) {
                return binarySearch(nums, mid + 1, end, target) || search(nums, start, mid - 1, target);
            }
            else if (nums[mid] > nums[end]) {
                return binarySearch(nums, start, mid - 1, target) || search(nums, mid + 1, end, target);
            }
            else {
                return search(nums, start, mid - 1, target) || search(nums, mid + 1, end - 1, target);
            }
        }

        private boolean binarySearch(int[] nums, int start, int end, int target) {
            if (end <= start) {
                return nums[start] == target;
            }
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, end, target);
            }
            else {
                return binarySearch(nums, start, mid - 1, target);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}