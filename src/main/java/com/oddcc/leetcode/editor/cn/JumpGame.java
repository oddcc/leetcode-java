// 55

package com.oddcc.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
       System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
       System.out.println(solution.canJump(new int[]{2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历，每个位置跳每种长度的方式都进行计算，找到一个就算找到答案，如果都没有则返回false
        // 思路1包含太多的重复运算
        // 思路2，动态规划，dp[i]表示从0出发，能否到达i
        public boolean canJump(int[] nums) {
            int len = nums.length;
            boolean[] dp = new boolean[len];
            dp[0] = true;
            for (int i = 0; i < len; i++) {
                if (!dp[i]) continue;
                for (int j = i; j <= i + nums[i]; j++) {
                    if (j < len) {
                        dp[j] = true;
                    }
                }
            }
            return dp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}