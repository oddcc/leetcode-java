// 639

package com.oddcc.leetcode.editor.cn;

public class DecodeWaysIi {
    public static void main(String[] args) {
        Solution solution = new DecodeWaysIi().new Solution();
        System.out.println(solution.numDecodings("*"));
        System.out.println(solution.numDecodings("1*"));
        System.out.println(solution.numDecodings("2*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，动态规划，注意分情况讨论，0、1~2、3~9、*
    class Solution {
        public int numDecodings(String s) {
            int M = 1000000007;
            // dp[i]表示到前i位为止共有多少种解码方法
            long[] dp = new long[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
            for (int i = 2; i <= s.length(); i++) {
                char cur = s.charAt(i - 1);
                char pre = s.charAt(i - 2);
                if (cur == '*') {
                    // 第i位单独解码
                    dp[i] = 9 * dp[i - 1];
                    // 第i位跟i-1位一起解码
                    if (pre == '1')
                        dp[i] = (dp[i] + 9 * dp[i - 2]) % M;
                    else if (pre == '2')
                        dp[i] = (dp[i] + 6 * dp[i - 2]) % M;
                    else if (pre == '*')
                        dp[i] = (dp[i] + 15 * dp[i - 2]) % M;
                }
                else {
                    // 第i位是0时，无法独立解码
                    // 第i位不是0时，可以独立解码
                    dp[i] = cur == '0' ? 0 : dp[i - 1];
                    // 第i位与i-1位共同解码
                    if (pre == '1')
                        dp[i] = (dp[i] + dp[i - 2]) % M;
                    else if (pre == '2' && cur <= '6')
                        dp[i] = (dp[i] + dp[i - 2]) % M;
                    // 当i-1位是*时，i位<=6，对应*是1和2两种
                    // i位>6时，*只能为1
                    else if (pre == '*')
                        dp[i] = (dp[i] + (cur <= '6' ? 2 : 1) * dp[i - 2]) % M;
                }
                dp[i] %= M;
            }
            return (int) dp[s.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}