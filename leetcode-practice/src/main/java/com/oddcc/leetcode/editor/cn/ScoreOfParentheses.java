// 856

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses().new Solution();
        System.out.println(solution.scoreOfParentheses("()"));
        System.out.println(solution.scoreOfParentheses("(())"));
        System.out.println(solution.scoreOfParentheses("()()"));
        System.out.println(solution.scoreOfParentheses("(()(()))"));
        System.out.println(solution.scoreOfParentheses("(())()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            char[] chars = s.toCharArray();
            int l = 0;
            int r = s.length() - 1;
            return getScore(chars, l, r);
        }

        private int getScore(char[] chars, int l, int r) {
            if (l < 0 || l >= chars.length || r < 0 || r >= chars.length || r - l < 1) {
                return 0;
            }
            if (chars[l] == '(' && chars[l + 1] == ')') {
                return 1 + getScore(chars, l + 2, r);
            }
            Deque<Character> stack = new LinkedList<>();
            int start = l;
            stack.push(chars[start++]);
            while (!stack.isEmpty()) {
                if (chars[start] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(chars[start]);
                }
                start++;
            }
            return 2 * getScore(chars, l + 1, start - 1) + getScore(chars, start, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}