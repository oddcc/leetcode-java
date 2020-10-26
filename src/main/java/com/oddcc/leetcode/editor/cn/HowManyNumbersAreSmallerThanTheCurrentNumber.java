package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        Solution solution = new HowManyNumbersAreSmallerThanTheCurrentNumber().new Solution();
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 可以用类似计数排序的思路，遍历一遍原始数组nums，生成一个计数的数组int[] count，其中count[i]对应原始数组nums中i值出现的次数
        // 再从左到右遍历count数组，生成另一个数组sum，另sum[i] = sum[i - 1] + count[i - 1]；
        // 时间复杂度O(n)，空间复杂度O(n)
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] count = new int[101]; // 题目中提到值的范围是[0,100]
            for (int i : nums) {
                count[i]++;
            }
            int[] lowerSum = new int[101];
            for (int i = 0; i < count.length; i++) {
                if (i - 1 < 0) {
                    lowerSum[i] = 0;
                    continue;
                }
                lowerSum[i] = lowerSum[i - 1] + count[i - 1];
            }
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ans[i] = lowerSum[nums[i]];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}