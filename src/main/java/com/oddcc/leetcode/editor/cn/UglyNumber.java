// 263

package com.oddcc.leetcode.editor.cn;

public class UglyNumber {
    public static void main(String[] args) {
        Solution solution = new UglyNumber().new Solution();
        System.out.println(solution.isUgly(6));
        System.out.println(solution.isUgly(8));
        System.out.println(solution.isUgly(14));
        System.out.println(solution.isUgly(1));
        System.out.println(solution.isUgly(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，递归
        public boolean isUgly(int n) {
            if (n == 0) return false;
            if (n == 1) return true;
            return (n % 2 == 0 && isUgly(n / 2)) || (n % 3 == 0 && isUgly(n / 3)) || (n % 5 == 0 && isUgly(n / 5));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}