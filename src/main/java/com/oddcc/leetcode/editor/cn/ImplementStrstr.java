// 28


package com.oddcc.leetcode.editor.cn;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("a", ""));
        System.out.println(solution.strStr("mississippi", "sippi"));
        System.out.println(solution.strStr("mississippi", "issip"));
        System.out.println(solution.strStr("mississippi", "issipi"));
        System.out.println(solution.strStr("", ""));
        System.out.println(solution.strStr("aaa", "aaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 是一个子串的匹配问题
        // 思路1，暴力法，如果找到匹配的字母，则向后匹配，不断往后移动起点，直到字符串末尾
        // 思路2，思路1优化，双指针
        public int strStr(String haystack, String needle) {
            if (needle.length() > haystack.length()) return -1;
            if (needle.isEmpty()) return 0;
            int current = 0;
            while (current < haystack.length() - needle.length() + 1) {
                int i = 0;
                while (i < needle.length() && current + i < haystack.length() && needle.charAt(i) == haystack.charAt(current + i)) {
                    i++;
                }
                if (i == needle.length()) {
                    return current;
                }
                current++;
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}