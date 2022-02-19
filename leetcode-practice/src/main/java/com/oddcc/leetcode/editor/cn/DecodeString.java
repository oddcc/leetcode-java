// 394

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.StringUtils;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("abc3[cd]xyz"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，按题意进行字符串解析即可
        public String decodeString(String s) {
            return doDecode(s, 0, s.length());
        }

        private String doDecode(String s, int start, int end) {
            StringBuilder ans = new StringBuilder();
            int p = start;
            while (p < end) {
                if (isLetter(s.charAt(p))) {
                    ans.append(s.charAt(p++));
                    continue;
                }
                // 找数字
                int repeat = 0;
                while (isDigit(s.charAt(p))) {
                    repeat = s.charAt(p) - '0' + repeat * 10;
                    p++;
                }
                // 找字符串，递归调用
                String str = null;
                if (s.charAt(p) == '[') {
                    Deque<Character> stack = new LinkedList<>();
                    stack.add(s.charAt(p)); // 用栈来确定需要递归的字符串的起止位置
                    int l = p + 1; // 当先指向[，开始位置是p+1
                    while (!stack.isEmpty()) { // 当栈空时，说明匹配到了开始的那个[
                        p++;
                        if (s.charAt(p) == '[') stack.push(s.charAt(p));
                        if (s.charAt(p) == ']') stack.pop();
                    }
                    str = doDecode(s, l, p++); // 上面跳出循环时，p指向一个]，所以这里是p++
                }
                else {
                    StringBuilder sb = new StringBuilder();
                    while (isLetter(s.charAt(p))) {
                        sb.append(s.charAt(p));
                        p++;
                    }
                    str = sb.toString();
                }
                // 字符串拼接
                ans.append(StringUtils.repeat(str, Math.max(0, repeat)));
            }
            return ans.toString();
        }

        private boolean isDigit(char c) {
            return c >= '0' && c <= '9';
        }

        private boolean isLetter(char c) {
            return c >= 'a' && c <= 'z';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}