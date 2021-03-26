// 剑指 Offer 10- II

package com.oddcc.leetcode.editor.cn;

public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.numWays(2));
        System.out.println(solution.numWays(7));
        System.out.println(solution.numWays(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划
        public int numWays(int n) {
            if (n == 0) return 1;
            int[] dp = new int[n + 1]; // dp[i] 表示跳上第i阶台阶有多少种跳法
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
            return dp[n] % 1000000007;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}