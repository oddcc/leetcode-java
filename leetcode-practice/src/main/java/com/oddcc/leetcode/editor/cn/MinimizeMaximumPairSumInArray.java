// 1877

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {
        Solution solution = new MinimizeMaximumPairSumInArray().new Solution();
        System.out.println(solution.minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(solution.minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，排序+贪心
    // 设想数组中最大值x，如果要使和的最大值最小，x必须加一个尽可能小的数i，得到m1，跟任何一个其他数相加，结果都会大于m1
    // 假设y是仅小于x的数字，如果跟i相加，得到m2，会小于m1，但由于x只能跟大于等于i的数相加，使最终结果变大
    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int ans = -1;
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l++] + nums[r--];
                ans = Math.max(sum, ans);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}