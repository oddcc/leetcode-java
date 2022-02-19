// 剑指 Offer 14- II

package com.oddcc.leetcode.editor.cn;

import java.math.BigInteger;

public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(900));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划
        public int cuttingRope(int n) {
            // dp[i]表示长度为i的绳子分割后的最大乘积（包含分为1段，即不分割的结果）
            BigInteger[] dp = new BigInteger[n + 1];
            dp[1] = BigInteger.valueOf(1);
            for (int i = 2; i < n + 1; i++) {
                // j表示最新一段分割的长度，到i/2为止是因为，之后都是重复计算了
                dp[i] = BigInteger.ZERO;
                for (int j = 1; j < i / 2 + 1; j++) {
                    BigInteger x = BigInteger.valueOf(j).multiply(dp[i - j]);
                    if (dp[i].compareTo(x) < 0) {
                        dp[i] = x;
                    }
                    if (dp[i].compareTo(BigInteger.valueOf((long) j * (i - j))) < 0) {
                        dp[i] = BigInteger.valueOf((long) j * (i - j));
                    }
                }
            }
            return (dp[n].remainder(BigInteger.valueOf(1000000007))).intValue();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}