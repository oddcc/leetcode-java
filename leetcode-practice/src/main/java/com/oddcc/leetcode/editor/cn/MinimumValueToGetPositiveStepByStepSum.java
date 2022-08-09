// 1413

package com.oddcc.leetcode.editor.cn;

public class MinimumValueToGetPositiveStepByStepSum {
    public static void main(String[] args) {
        Solution solution = new MinimumValueToGetPositiveStepByStepSum().new Solution();
        System.out.println(solution.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(solution.minStartValue(new int[]{1, 2}));
        System.out.println(solution.minStartValue(new int[]{1, -2, -3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStartValue(int[] nums) {
            int ans = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                min = Math.min(min, sum);
            }
            if (min >= 1) {
                ans = 1;
            } else {
                ans = 1 - min;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}