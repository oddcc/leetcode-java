// 1190

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println(solution.reverseParentheses("(abcd)"));
        System.out.println(solution.reverseParentheses("(u(love)i)"));
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(solution.reverseParentheses("yfgnxf"));
        System.out.println(solution.reverseParentheses("((eqk((h))))"));
        System.out.println(solution.reverseParentheses("ta()usw((((a))))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,利用栈
    class Solution {
        public String reverseParentheses(String s) {
            Deque<String> stack = new LinkedList<>();
            for (Character c : s.toCharArray()) {
                if (c.equals('(')) {
                    stack.push("(");
                }
                else if (c.equals(')')) {
                    StringBuilder sb = new StringBuilder();
                    // 当前是有括号时，栈中应该有一个左括号跟它配对，两个括号之间的内容就是要反转的内容
                    // 这里append的顺序是出栈的顺序，所以已经是反转的内容
                    while (stack.peek() != null && !stack.peek().equals("(")) {
                        sb.append(stack.pop());
                    }
                    if (!stack.isEmpty()) stack.pop();
                    // 我们栈中存的是未反转的内容，所以这里要反转一下
                    stack.push(reverse(sb.toString()));
                }
                else {
                    stack.push(String.valueOf(c));
                }
            }
            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) ans.append(stack.pop());
            return reverse(ans.toString());
        }

        private String reverse(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.reverse();
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}