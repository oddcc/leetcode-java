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
        // 思路2，循环判断
        public boolean isUgly(int n) {
            while (n != 0) {
                if (n % 2 == 0) n /= 2;
                else if (n % 3 == 0) n /= 3;
                else if (n % 5 == 0) n /= 5;
                // 这里会是1或其他质数
                else {
                    break;
                }
            }
            return n == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}