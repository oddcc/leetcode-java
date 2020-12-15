// 738

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new MonotoneIncreasingDigits().new Solution();
        System.out.println(solution.monotoneIncreasingDigits(332));
        System.out.println(solution.monotoneIncreasingDigits(10));
        System.out.println(solution.monotoneIncreasingDigits(1234));
        System.out.println(solution.monotoneIncreasingDigits(1412));
        System.out.println(solution.monotoneIncreasingDigits(101));
        System.out.println(solution.monotoneIncreasingDigits(855832));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，从N向0遍历，返回第一个是单调递增的数
        // 思路2，观察如332，题目要求返回小于等于332的最大的单调递增的数
        public int monotoneIncreasingDigits(int N) {
            int[] bits = nToBits(N);
            int len = getLength(bits);
            for (int i = 0; i < len; i++) {
                if (bits[i] >= bits[i + 1]) continue;
                // 一旦出现低位小于高位的情况，则把所有低位都标为9，高位-1，这样得到的数是当前的最大单调递增数
                for (int j = i; j >= 0; j--) {
                    bits[j] = 9;
                }
                bits[i + 1]--;
            }
            return bitsToInt(bits, len);
        }

        private int bitsToInt(int[] bits, int len) {
            int n = 0;
            for (int i = len - 1; i >= 0; i--) {
                n = n * 10 + bits[i];
            }
            return n;
        }

        private int getLength(int[] bits) {
            int len = 0;
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == -1) break;
                len++;
            }
            return len;
        }

        private int[] nToBits(int n) {
            int[] bits = new int[10]; // 题意中最大是10位数，10^9，用于存放每一位数，低位存储数的高位，高位存储数的低位 332 -> {2,3,3}
            Arrays.fill(bits, -1);
            int tmp = n;
            int i = 0;
            while (tmp != 0) {
                int remain = tmp % 10;
                tmp = (tmp - remain) / 10;
                bits[i++] = remain;
            }
            return bits;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}