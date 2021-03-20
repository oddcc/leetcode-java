// 150

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，利用栈来运算，碰到数字就入栈，碰到符号，就出栈2个数字，并且把结果入栈，最后剩下的一个数字就是结果
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for (String token : tokens) {
                if (isDigit(token)) {
                    stack.push(Integer.parseInt(token));
                }
                else {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(calcu(a, b, token));
                }
            }
            return stack.pop();
        }

        private Integer calcu(int a, int b, String token) {
            if (token.equals("+")) return a + b;
            if (token.equals("-")) return a - b;
            if (token.equals("*")) return a * b;
            return a / b;
        }

        private boolean isDigit(String token) {
            return !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}