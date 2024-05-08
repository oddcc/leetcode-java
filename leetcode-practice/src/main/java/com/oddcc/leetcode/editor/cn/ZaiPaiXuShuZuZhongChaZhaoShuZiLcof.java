// 剑指 Offer 53 - I&&zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof

package com.oddcc.leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        // System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(solution.search(new int[]{}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，二分查找，找第一次出现和最后一次出现，计算中间差值
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) return 0;
            int first = findFirst(nums, target, 0, nums.length - 1);
            if (first == -1) return 0;
            int last = findLast(nums, target, 0, nums.length - 1);
            return last - first + 1;
        }

        private int findLast(int[] nums, int target, int left, int right) {
            if (right <= left) {
                if (nums[left] == target) return left;
                return -1;
            }
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                return findLast(nums, target, left, mid - 1);
            }
            else if (nums[mid] == target) {
                if (mid == nums.length - 1) return mid;
                if (nums[mid] < nums[mid + 1]) return mid;
                return findLast(nums, target, mid + 1, right);
            }
            else {
                return findLast(nums, target, mid + 1, right);
            }
        }

        private int findFirst(int[] nums, int target, int left, int right) {
            if (right <= left) {
                if (nums[left] == target) return left;
                return -1;
            }
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                return findFirst(nums, target, left, mid);
            }
            else {
                return findFirst(nums, target, mid + 1, right);
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}