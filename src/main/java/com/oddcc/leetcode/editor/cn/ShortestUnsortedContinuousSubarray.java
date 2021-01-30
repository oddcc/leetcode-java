// 581

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1}));
        System.out.println(solution.findUnsortedSubarray(new int[]{4, 3, 2, 1}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 2, 3, 3, 3})); // 题目没说不能重复
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 3, 3, 3, 3}));
        System.out.println(solution.findUnsortedSubarray(new int[]{3, -1, -1, -1, -1}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 2, 4, 5, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 要求O(n)的时间复杂度
        // 思路1，已排序的跟未排序的做对比，不同的地方就是边界
        public int findUnsortedSubarray(int[] nums) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            int left = 0;
            while (left < nums.length && nums[left] == sorted[left]) left++;
            int right = nums.length - 1;
            while (right >= 0 && nums[right] == sorted[right]) right--;
            if (right > left) return right - left + 1;
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}