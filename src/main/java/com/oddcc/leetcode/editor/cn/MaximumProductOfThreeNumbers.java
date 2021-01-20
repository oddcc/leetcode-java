// 628

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
        System.out.println(solution.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(solution.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(solution.maximumProduct(new int[]{-1, -2, -3, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，找规律，如果所有数都是正数，则结果是三个最大数的乘积，如果所有数都是负数，则结果也是三个最大数的乘积
        // 如果有正数有负数，则最大应该是两个负数一个正数，或两个正数一个负数的乘积中大的那个
        //                               这两个负数应尽可能小             这个负数应尽可能小
        // 如果将数组排序，则上面的情况分别是
        // 1，三个最大数的乘积，就是数组最后三个数的乘积
        // 2，两个尽可能小的负数和一个尽可能大的正数，是数组最后一个和前两个数的乘积
        // 3，两个尽可能大的正数和一个尽可能小的负数，跟第一种情况相同
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}