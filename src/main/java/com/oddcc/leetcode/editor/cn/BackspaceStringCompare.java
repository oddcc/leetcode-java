package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
//        System.out.println(solution.backspaceCompare("ab#c", "ab#c"));
//        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
//        System.out.println(solution.backspaceCompare("a##c", "#a#c"));
        System.out.println(solution.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 要遍历两个字符串，判断相等，可以用栈来解决，如果最后生成的字符串相等就相等
        // 规则是遇到字母就入栈，遇到#就出栈，如果栈为空，则忽略当前#
        public boolean backspaceCompare(String S, String T) {
            Deque<Character> stackS = resolve(S);
            Deque<Character> stackT = resolve(T);
            if (stackS.size() != stackT.size()) return false;
            while (!stackS.isEmpty()) {
                if (!stackS.pop().equals(stackT.pop())) return false;
            }
            return true;
        }

        private Deque<Character> resolve(String s) {
            Deque<Character> stack = new LinkedList<>();
            for (Character c : s.toCharArray()) {
                if (c == '#') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                else {
                    stack.push(c);
                }
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}