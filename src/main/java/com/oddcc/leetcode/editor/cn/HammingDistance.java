// 461

package com.oddcc.leetcode.editor.cn;

public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
        System.out.println(solution.hammingDistance(1, 4));
        System.out.println(solution.hammingDistance(3, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,转成2进制形式,比较并计数,不足的要补0
    class Solution {
        public int hammingDistance(int x, int y) {
            int ans = 0;
            String xBin = Integer.toBinaryString(x);
            String yBin = Integer.toBinaryString(y);
            int padding;
            int len;
            if (xBin.length() > yBin.length()) {
                padding = xBin.length() - yBin.length();
                yBin = "0".repeat(padding) + yBin;
                len = yBin.length();
            }
            else {
                padding = yBin.length() - xBin.length();
                if (padding != 0) {
                    xBin = "0".repeat(padding) + xBin;
                }
                len = xBin.length();
            }
            for (int i = 0; i < len; i++) {
                if (xBin.charAt(i) != yBin.charAt(i)) ans++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}