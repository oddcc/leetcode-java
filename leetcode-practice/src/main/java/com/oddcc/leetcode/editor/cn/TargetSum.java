// 494

package com.oddcc.leetcode.editor.cn;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWays(new int[]{1}, 1));
        System.out.println(solution.findTargetSumWays(new int[]{1, 2, 7, 9, 981}, 1000000000));
        System.out.println(solution.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，挨个尝试，其实是一颗决策树，到叶子节点之后，如果和不是S，则不符合条件
        // 思路2，动态规划，在思路1中，会包含大量的重复计算，我们要把重复计算的信息存储起来，就是动态规划
        // 题目中给出，S <= 1000
        // dp[i][j]表示前i-1个数，和为j时有多少种方案
        // dp[i][j] = dp[i -1][j + nums[i]] + dp[i -1][j - nums[i]]
        public int findTargetSumWays(int[] nums, int S) {
            if (S > 1000) return 0;
            int len = nums.length;
            // 因为中间的S可能为负数，但是因为最大为1000，所以最小为-1000
            // 这里[0] ~ [1000] 表示-1000 ~ 0，[1001] ~ [2001]表示 1 ~ 1000
            int[][] dp = new int[len][2001];
            dp[0][nums[0] + 1000] = 1;
            dp[0][-nums[0] + 1000] += 1; // 特别处理nums[0] == 0的情况
            for (int i = 1; i < len; i++) {
                for (int j = -1000; j <= 1000; j++) {
                    int plus = (j + nums[i] <= 1000 && j + nums[i] >= -1000) ? dp[i - 1][j + nums[i] + 1000] : 0;
                    int minus = (j - nums[i] <= 1000 && j - nums[i] >= -1000) ? dp[i - 1][j - nums[i] + 1000] : 0;
                    dp[i][j + 1000] = plus + minus;
                }
            }
            return dp[len - 1][S + 1000];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}