// 633

package com.oddcc.leetcode.editor.cn;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        System.out.println(solution.judgeSquareSum(0));
        System.out.println(solution.judgeSquareSum(1));
        System.out.println(solution.judgeSquareSum(2));
        System.out.println(solution.judgeSquareSum(3));
        System.out.println(solution.judgeSquareSum(4));
        System.out.println(solution.judgeSquareSum(2147483646));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力+剪枝，对于确定的c来说，a和b的取值只能在[0,根号c]之间，范围之外的不可能是答案
        // 另外对于固定的c和a，可以通过c-a*a = b*b这样的方式，确定b的值，这是一个O(1)的计算
        public boolean judgeSquareSum(int c) {
            // 这里如果不用long的话，a*a可能会溢出，就会造成死循环
            for (long a = 0; a * a <= c; a++) {
                double b = Math.sqrt(c - a * a);
                if (b ==(int) b) return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}