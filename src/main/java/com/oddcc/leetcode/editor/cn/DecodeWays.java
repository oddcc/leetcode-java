// 91

package com.oddcc.leetcode.editor.cn;

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("0"));
        System.out.println(solution.numDecodings("06"));
        System.out.println(solution.numDecodings("1"));
        System.out.println(solution.numDecodings("10"));
        System.out.println(solution.numDecodings("1201234"));
        System.out.println(solution.numDecodings("123123"));
        System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，递归，超时
        public int numDecodings(String s) {
            return numDecodings(s.toCharArray(), 0);
        }

        private int numDecodings(char[] chars, int start) {
            if (start > chars.length - 1) return 0;
            if (chars[start] == '0') return 0;
            // 剩2个字符时
            if (start == chars.length - 2) {
                // 如果2开头，且小于等于26，那么选两个是一种方法，分开选是一种方法
                if (chars[start] == '2' && chars[start + 1] <= '6') return 1 + numDecodings(chars, start + 1);
                // 如果是1开头，同上，是两种方法
                if (chars[start] == '1') return 1 + numDecodings(chars, start + 1);
                // 如果是其他数字开头，只有分开选一种方法
                return 1;
            }
            // 剩1个字符时
            if (start == chars.length - 1) {
                // 如果这个字符是0，没有这种选法，返回0；其他字符返回1
                if (chars[start] == '0') return 0;
                return 1;
            }
            // 如果剩多于2个字符，且开始是小于等于26的，或者是1x的，那么都是两种选法
            if ((chars[start] == '2' && chars[start + 1] <= '6') || chars[start] == '1') return numDecodings(chars, start + 1) + numDecodings(chars, start + 2);
            // 否则的话，是一种选法
            return numDecodings(chars, start + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}