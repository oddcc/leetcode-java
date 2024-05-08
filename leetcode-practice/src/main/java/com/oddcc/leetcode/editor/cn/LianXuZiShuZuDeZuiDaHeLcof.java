// 剑指 Offer 42&&lian-xu-zi-shu-zu-de-zui-da-he-lcof

package com.oddcc.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1, 7, -2, -5, 10, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，贪心+分治
        // 思路2，动态规划
        public int maxSubArray(int[] nums) {
            // dp[i]表示以i结尾的子数组的最大加和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int ans = dp[0];
            for (int i = 1; i < nums.length; i++) {
                // 要求以第i个数结尾，要么跟前面组成子数组，要么自己单独计算，我们要求最大值，所以选大的
                dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}