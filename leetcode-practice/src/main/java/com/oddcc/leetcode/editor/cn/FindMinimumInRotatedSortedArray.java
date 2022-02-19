// 153

package com.oddcc.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.findMin(new int[]{11, 13, 15, 17}));
        System.out.println(solution.findMin(new int[]{2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 每个元素是唯一的，所以可以通过对比子数组的头尾，来判断子数组是有序还是无序
        // 思路1，二分查找，找小于nums[0]的数，当遇到更小的时，更新这个查找的目标，最终一定是找不到，这个目标值就是最小值
        // 思路2，优化思路1，用循环而不是递归
        public int findMin(int[] nums) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            // 当left和right重合时，说明要结束了
            while (left < right) {
                int mid = (right - left) / 2 + left;
                // nums[mid] > nums[right]，说明left~mid是有序的，nums[mid]是区间中的最大值，最小值在mid+1~right中
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                }
                // nums[mid] < nums[right]，说明mid~right是有序的，且nums[mid]为区间中最小值，答案可能在left~mid中
                else {
                    right = mid;
                }
            }
            return nums[left];
        }

        private int search(int[] nums, int left, int right, int target) {
            if (left >= right) {
                return Math.min(target, nums[left]);
            }
            int mid = (right - left) / 2 + left;
            // left~mid是升序，nums[left]一定小于等于nums[mid]
            if (nums[mid] >= nums[left]) {
                return search(nums, mid + 1, right, Math.min(nums[left], target));
            }
            // mid~right是升序，更小的值只可能出现在left~mid
            return search(nums, left, mid - 1, Math.min(nums[mid], target));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}