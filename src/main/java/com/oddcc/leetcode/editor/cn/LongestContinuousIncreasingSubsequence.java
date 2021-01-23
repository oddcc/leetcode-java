// 674

package com.oddcc.leetcode.editor.cn;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
        System.out.println(solution.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1}));
        System.out.println(solution.findLengthOfLCIS(new int[]{}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，一次遍历
        public int findLengthOfLCIS(int[] nums) {
            int ans = 0;
            int start = 0;
            Integer pre = null;
            for (int i = 0; i < nums.length; i++) {
                if (pre == null) {
                    pre = nums[i];
                    ans = 1;
                    continue;
                }
                if (nums[i] <= pre) {
                    int len = i - start;
                    if (len > ans) ans = len;
                    start = i;
                }
                else {
                    if (i == nums.length - 1) {
                        int len = i - start + 1;
                        if (len > ans) ans = len;
                        break;
                    }
                }
                pre = nums[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}