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
        // 思路1，一次遍历+两次二分查找，先遍历一次，找到数组pivot，然后分成两个有序的子数组进行二分查找
        public boolean search(int[] nums, int target) {
            int len = nums.length;
            if (len == 1) return nums[0] == target;
            int p = 1;
            while (p < len && nums[p] >= nums[p - 1]) {
                p++;
            }
            // 如果p==len，说明移动到最后都没找到
            if (p == len) {
                return binarySearch(nums, 0, len - 1, target);
            }
            // 0~p-1是一个单调数组，p~len-1是一个单调数组
            return binarySearch(nums, 0, p - 1, target) || binarySearch(nums, p, len - 1, target);
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