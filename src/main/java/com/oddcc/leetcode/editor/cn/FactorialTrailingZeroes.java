package com.oddcc.leetcode.editor.cn;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(30));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int ans = 0;
            while (n != 0) {
                ans += n / 5;
                n = n / 5;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}