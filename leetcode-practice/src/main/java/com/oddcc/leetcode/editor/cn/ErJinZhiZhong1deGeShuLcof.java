// 剑指 Offer 15&&er-jin-zhi-zhong-1de-ge-shu-lcof

package com.oddcc.leetcode.editor.cn;

public class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
        System.out.println(solution.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
        System.out.println(solution.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000", 2)));
        System.out.println(solution.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        // 思路1，循环右移计数
        public int hammingWeight(int n) {
            int ans = 0;
            while (n != 0) {
                if ((n & 1) == 1) ans++;
                n = n >>> 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}