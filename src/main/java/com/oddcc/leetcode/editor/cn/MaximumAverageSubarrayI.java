// 643

package com.oddcc.leetcode.editor.cn;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(solution.findMaxAverage(new int[]{-1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，滑动窗口，维护一个平均值即可，记下最大的
        public double findMaxAverage(int[] nums, int k) {
            Double ans = null;
            int len = nums.length;
            int right = k - 1;
            long total = 0;
            while (right < len) {
                if (right == k - 1) {
                    for (int i = 0; i <= right; i++) total += nums[i];
                }
                else {
                    total += nums[right];
                    total -= nums[(right - k + 1) - 1];
                }
                right++;
                if (ans == null) {
                    ans = total / (double) k;
                } else {
                    ans = Math.max(ans, total / (double) k);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}