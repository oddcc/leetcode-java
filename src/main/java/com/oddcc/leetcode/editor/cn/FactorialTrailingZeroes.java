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
            for (int i = 1; i <= n; i++) {
                int tmp = i;
                while (tmp / 5 != 0) {
                    if (tmp % 5 == 0) {
                        ans++;
                    } else {
                        break;
                    }
                    tmp = tmp / 5;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}