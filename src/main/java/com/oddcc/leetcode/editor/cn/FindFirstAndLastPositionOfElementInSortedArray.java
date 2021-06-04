// 34
package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{0, 0, 2, 3, 4, 4, 4, 5}, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，O(N)的解法
        // 思路2，优化查找查找左边和右边的时候，都可以使用二分查找来减少时间复杂度；分别是左边->找第一个出现的target，右边->找最后一个出现的target
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            int start = findFirst(nums, 0, nums.length - 1, target);
            System.out.println(start);
            if (start == -1) return new int[]{-1, -1};
            int end = findLast(nums, start, nums.length - 1, target);
            return new int[]{start, end};
        }

        /**
         * 二分查找第一个出现的target，找不到则返回-1
         * @param nums
         * @param start
         * @param end
         * @param target
         * @return
         */
        private int findFirst(int[] nums, int start, int end, int target) {
            if (start >= end) {
                if (nums[start] == target) return start;
                return -1;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                return findFirst(nums, mid + 1, end, target);
            }
            else {
                return findFirst(nums, start, mid, target);
            }
        }

        /**
         * 二分查找最后一个出现的target，找不到则返回-1
         * @param nums
         * @param start
         * @param end
         * @param target
         * @return
         */
        private int findLast(int[] nums, int start, int end, int target) {
            if (start >= end) {
                if (nums[start] == target) return start;
                return -1;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                return findLast(nums, mid + 1, end, target);
            }
            if (nums[mid] == target) {
                int i = findLast(nums, mid + 1, end, target);
                if (i != -1) return i;
                return mid;
            }
            else {
                return findLast(nums, start, mid - 1, target);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}