// 509

package com.oddcc.leetcode.editor.cn;

public class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        System.out.println(solution.fib(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，递归，不写了
        // 思路2，动态规划
        private int[] dp = new int[31];

        public int fib(int n) {
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}