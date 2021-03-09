// 1047

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
        System.out.println(solution.removeDuplicates("aaaaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，利用栈，遇到一个新的字符要入栈，随后根据后续状态判断栈顶元素是否要出栈
        // 如果遇到与栈顶相同的新元素，则栈顶元素出栈，否则新元素入栈
        public String removeDuplicates(String S) {
            Deque<Character> stack = new LinkedList<>();
            int i = 0;
            while (i < S.length()) {
                if (stack.isEmpty()) {
                    stack.push(S.charAt(i++));
                    continue;
                }
                if (stack.peek() == S.charAt(i)) {
                    stack.pop();
                }
                else {
                    stack.push(S.charAt(i));
                }
                i++;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) sb.append(stack.pop());
            sb.reverse();
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}