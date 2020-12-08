// 231

package com.oddcc.leetcode.editor.cn;

public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
        System.out.println(solution.isPowerOfTwo(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n == 1) return true;
            if (n % 2 != 0) return false;
            while (n > 2) {
                n = n >> 1;
                if (n % 2 != 0) return false;
            }
            return n == 2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}