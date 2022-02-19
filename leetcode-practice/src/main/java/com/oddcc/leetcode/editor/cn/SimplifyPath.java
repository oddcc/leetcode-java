// 71

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // use stack
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> stack = new LinkedList<>();
            String[] splitPath = path.split("/");
            for (String s : splitPath) {
                if (s.equals("")) continue;
                if (s.equals(".")) continue;
                if (s.equals("..")) {
                    if (stack.isEmpty()) continue;
                    stack.pop();
                    continue;
                }
                stack.push(s);
            }
            return stack2Path(stack);
        }

        private String stack2Path(Deque<String> stack) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            for (Iterator<String> it = stack.descendingIterator(); it.hasNext(); ) {
                String d = it.next();
                sb.append(d);
                sb.append("/");
            }
            if (stack.size() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}