// 224

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        // System.out.println(solution.calculate("1 + 1"));
        // System.out.println(solution.calculate(" 2-1 + 2 "));
        // System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(solution.calculate("-2+ 1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，需要利用栈，但需要注意多位数字，负数的情况
        public int calculate(String s) {
            Deque<Integer> ops = new LinkedList<>();
            ops.push(1);
            int sign = 1;

            int ret = 0;
            int n = s.length();
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == ' ') {
                    i++;
                }
                else if (s.charAt(i) == '+') {
                    sign = ops.peek();
                    i++;
                }
                else if (s.charAt(i) == '-') {
                    sign = -ops.peek();
                    i++;
                }
                else if (s.charAt(i) == '(') {
                    ops.push(sign);
                    i++;
                }
                else if (s.charAt(i) == ')') {
                    ops.pop();
                    i++;
                }
                else {
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ret += sign * num;
                }
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}