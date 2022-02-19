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
        // 思路3，贪心，可以发现，题目中有最远可到达位置的概念，因为最大限制内跳几格是没有限制的
        // 所以只要能到达i，则所有i-1的地方都能到，只要在遍历的时候，发现最远达到的地方>=nums.len - 1，则说明能到达
        public boolean canJump(int[] nums) {
            int max = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (max < i) break; // 发现到不了，直接返回
                max = Math.max(max, i + nums[i]);
            }
            return max >= len - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}