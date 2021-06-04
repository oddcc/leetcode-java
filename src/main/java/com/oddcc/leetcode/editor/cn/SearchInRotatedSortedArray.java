// 33
package com.oddcc.leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
//        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
//        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(solution.search(new int[]{1}, 1));
//        System.out.println(solution.search(new int[]{}, 0));
//        System.out.println(solution.search(new int[]{5,1,3}, 1));
        System.out.println(solution.search(new int[]{5,1,3}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 直接找，最差O(n)的复杂度
        // 数组变化后，无论从哪里分开，我们都可以判断，哪边是有序的、哪边是无序的，或者两边都是有序的；重点在于题目说了数组中没有重复元素
        // 可以根据有序数组的上下界判断target是否在其中，如果在，转化为普通的二分查找问题；如果不在，对无序的另一边重复刚才的逻辑
        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            return doSearch(nums, 0, nums.length - 1, target);
        }

        private int doSearch(int[] nums, int low, int high, int target) {
            if (low >= high) {
                return nums[low] == target ? low : -1;
            }
            int mid = low + ((high - low) / 2);
            // 说明 low ~ mid 有序
            if ((nums[low] <= nums[mid])) {
                // target在有序的这边
                if ((nums[low] <= target && nums[mid] >= target)) {
                    return binarySearch(nums, low, mid, target);
                } else {
                    return doSearch(nums, mid + 1, high, target);
                }
            }
            // 说明 mid ~ high 有序
            else {
                if ((nums[mid] <= target && nums[high] >= target)) {
                    return binarySearch(nums, mid, high, target);
                } else {
                    return doSearch(nums, low, mid - 1, target);
                }
            }
        }

        private int binarySearch(int[] nums, int low, int high, int target) {
            if (low >= high) {
                return nums[low] == target ? low : -1;
            }
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= target) {
                return binarySearch(nums, low, mid, target);
            }
            else {
                return binarySearch(nums, mid + 1, high, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}