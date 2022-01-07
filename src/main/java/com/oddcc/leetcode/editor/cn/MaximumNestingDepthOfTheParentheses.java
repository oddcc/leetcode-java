// 1614

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        Solution solution = new MaximumNestingDepthOfTheParentheses().new Solution();
        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(solution.maxDepth("1+(2*3)/(2-1)"));
        System.out.println(solution.maxDepth("1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 确认了给的是有效括号字符串，可以用栈来做，最大栈深度就是最大嵌套的层数
    class Solution {
        public int maxDepth(String s) {
            int res = 0;
            Deque<Character> stack = new LinkedList<>();
            for (Character c: s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    stack.pop();
                }
                res = Math.max(res, stack.size());
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}