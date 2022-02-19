// 191

package com.oddcc.leetcode.editor.cn;

public class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new NumberOf1Bits().new Solution();
        System.out.println(solution.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
        System.out.println(solution.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000", 2)));
        System.out.println(solution.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 观察可知，奇数二进制表示末尾是1，偶数是0
    // 思路1，利用数字不断右移来统计i的数量
    public class Solution {
        private int MASK = 1;
        private int LEN = 32;

        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            for (int i = 0; i < LEN; i++) {
                if ((n & MASK) == 1) ans++;
                n = n >>> 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}