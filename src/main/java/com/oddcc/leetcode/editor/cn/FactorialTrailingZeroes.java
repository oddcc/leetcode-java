package com.oddcc.leetcode.editor.cn;

import java.math.BigInteger;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(30));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法1，先算出阶乘的结果，再看有几个零；n的范围太大，会溢出
        public int trailingZeroes(int n) {
            int ans = 0;
            BigInteger factorial = calcFactorial(n);
            String s = String.valueOf(factorial);
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    ans++;
                }
                else {
                    break;
                }
            }
            return ans;
        }

        private BigInteger calcFactorial(int n) {
            BigInteger ans = new BigInteger("1");
            while (n > 0) {
                ans = ans.multiply(BigInteger.valueOf(n));
                n--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}