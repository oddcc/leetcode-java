// 377

package com.oddcc.leetcode.editor.cn;

public class CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIv().new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{9}, 3));
        System.out.println(solution.combinationSum4(new int[]{2, 1, 3}, 35));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，回溯法，超时
        // 思路2，动态规划
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1]; // dp[i]表示和为i的方式有几种
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    // 因为数字都是正数，所以这里可以进行剪枝
                    if (num <= i) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}