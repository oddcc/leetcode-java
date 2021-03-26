// 剑指 Offer 10- I

package com.oddcc.leetcode.editor.cn;

public class FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(48));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划提高效率
        public int fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
            return dp[n] % 1000000007;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}