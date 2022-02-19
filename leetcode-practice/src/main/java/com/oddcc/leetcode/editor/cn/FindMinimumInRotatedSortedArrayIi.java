// 154

package com.oddcc.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
        System.out.println(solution.findMin(new int[]{1, 3, 5}));
        System.out.println(solution.findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(solution.findMin(new int[]{3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，二分查找
        public int findMin(int[] nums) {
            return findMin(nums, 0, nums.length - 1);
        }

        private int findMin(int[] nums, int l, int r) {
            if (r - l <= 1) {
                return Math.min(nums[l], nums[r]);
            }
            int m = l + (r - l) / 2;
            if (nums[m] < nums[l]) {
                return findMin(nums, l, m);
            }
            else if (nums[m] > nums[l]) {
                return Math.min(nums[l], findMin(nums, m + 1, r));
            }
            else {
                return Math.min(findMin(nums, l + 1, m - 1), findMin(nums, m, r));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}