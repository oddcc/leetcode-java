// 190

package com.oddcc.leetcode.editor.cn;

public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
        System.out.println(Integer.toBinaryString(solution.reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2))));
        System.out.println(Integer.toBinaryString(solution.reverseBits(Integer.parseUnsignedInt("11111111111111111111111111111101", 2))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        // 思路1，直接转换
        public int reverseBits(int n) {
            int LOW_MASK = 1;
            StringBuilder ans =new StringBuilder();
            for (int i = 0; i < 32; i++) {
                int tmp = n & LOW_MASK;
                ans.append(tmp);
                System.out.print(tmp);
                n = n >>> 1;
            }
            System.out.println();
            return Integer.parseUnsignedInt(ans.toString(), 2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}