// 316

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
        // System.out.println(solution.removeDuplicateLetters("bcabc"));
        // System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution.removeDuplicateLetters("bbcaac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 问题的关键在于结果得是最小的字典序，从"cbacdcbc" -> "acdb"来看，还不能打乱字母原有的顺序，比如b就不能在a前面
        // 两次遍历+单调队列
        public String removeDuplicateLetters(String s) {
            int[] counter = new int[26];
            for (char c : s.toCharArray()) {
                counter[c - 'a']++;
            }
            boolean[] inStack = new boolean[26]; // 表示当前字符是否已包含在栈中
            Deque<Character> stack = new LinkedList<>(); // 遍历过程中，会把最终答案留在栈中，而把要删除的字符都出栈
            for (char c : s.toCharArray()) {
                // 如果当前字符已包含在答案中，则跳过下面的流程，并把数量-1表示该字符已处理
                if (inStack[c - 'a']) {
                    counter[c - 'a']--;
                    continue;
                }
                // 如果当前字符小于栈顶字符，则有可能需要弹出栈顶字符
                while (!stack.isEmpty() && stack.peek() > c) {
                    char x = stack.peek();
                    // 如果栈顶字符只剩1个了，则不出栈
                    if (counter[x - 'a'] <= 1) {
                        inStack[x - 'a'] = true;
                        break;
                    }
                    // 如果栈顶字符多余1个，则后面还有机会碰到，先出栈，并把数量-1
                    else {
                        counter[x - 'a']--;
                        inStack[x - 'a'] = false;
                        stack.pop();
                    }
                }
                // 如果当前字符答案中没有，则入栈
                if (!inStack[c - 'a']) {
                    stack.push(c);
                    inStack[c-'a'] = true;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}