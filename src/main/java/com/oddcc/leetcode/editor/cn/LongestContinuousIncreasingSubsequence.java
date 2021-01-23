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
            for (int i = 0; i < nums.length; i++) {
                // 遍历时判断要不要更新start的位置
                if (i > 0 && nums[i] <= nums[i - 1]) {
                    start = i;
                }
                // 每次遇到一个新元素，都更新ans，即ans就是到i位置的最长子串的长度
                ans = Math.max(ans, i - start + 1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}