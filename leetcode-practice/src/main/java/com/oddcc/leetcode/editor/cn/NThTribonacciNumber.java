// 1137

package com.oddcc.leetcode.editor.cn;

public class NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (n == 2) return 1;
            int n1 = 0;
            int n2 = 1;
            int n3 = 1;
            int ans = 0;
            for (int i = 3; i <= n; i++) {
                ans = n1 + n2 + n3;
                n1 = n2;
                n2 = n3;
                n3 = ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}