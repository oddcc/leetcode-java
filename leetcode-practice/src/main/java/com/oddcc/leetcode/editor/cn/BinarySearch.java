// 704

package com.oddcc.leetcode.editor.cn;

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            return binarySearch(nums, 0, len - 1, target);
        }

        private int binarySearch(int[] nums, int left, int right, int target) {
            if (right <= left) {
                if (nums[left] == target) {
                    return left;
                }
                return -1;
            }
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return binarySearch(nums, left, mid - 1, target);
            }
            else {
                return binarySearch(nums, mid + 1, right, target);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}