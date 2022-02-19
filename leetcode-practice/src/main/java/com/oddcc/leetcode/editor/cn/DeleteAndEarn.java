// 740

package com.oddcc.leetcode.editor.cn;

public class DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(solution.deleteAndEarn(new int[]{1, 8, 5, 9, 6, 9, 4, 1, 7, 3, 3, 6, 3, 3, 8, 2, 6, 3, 2, 2, 1, 2, 9, 8, 7, 1, 1, 10, 6, 7, 3, 9, 6, 10, 5, 4, 10, 1, 6, 7, 4, 7, 4, 1, 9, 5, 1, 5, 7, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，暴力法+回溯，超时
    // 思路2，先转换问题，再动态规划，选择了x，则表示可以选择所有的x，也表示不能选择所有的x+1和x-1
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int max = 0;
            for (int n : nums) max = Math.max(max, n);
            int[] sum = new int[max + 1];
            for (int n : nums) {
                sum[n] += n;
            }
            // 把问题转化为，sum[i]中元素不能连续的选（选了i就不能选i-1和i+1），最大和是多少
            int[][] dp = new int[max + 1][2]; // sum中截止i为止，dp[i][0]表示，不选i最大和，dp[i][1]表示选了i的最大和
            for (int i = 1; i < max + 1; i++) {
                // 选sum[i]
                dp[i][1] = sum[i] + dp[i - 1][0];
                // 不选sum[i]
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
            return Math.max(dp[max][0], dp[max][1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}