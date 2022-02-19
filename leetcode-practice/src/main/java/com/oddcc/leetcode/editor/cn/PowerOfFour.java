// 342

package com.oddcc.leetcode.editor.cn;

public class PowerOfFour {
    public static void main(String[] args) {
        Solution solution = new PowerOfFour().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，循环/4，如果能得到1就说明是，否则不是
    // 思路2，题目不让用循环或递归来解，可以考虑位运算，4的次幂，二进制表示中应该是只有一位1，且每次右移2位（除4），最终能得到1，即通过m*2次右移，1能在最低位
    // 但是题目不让使用循环和递归，又已知n是一个32位的有符号int，我们可以构造一个掩码，来确定1到底在哪一位
    class Solution {
        public boolean isPowerOfFour(int n) {
            return n > 0 && (n & (n - 1)) == 0 && (n & 0b1010101010101010101010101010101) == n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}