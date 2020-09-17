//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Constraints: 
//
// 
// haystack and needle consist only of lowercase English characters. 
// 
// Related Topics 双指针 字符串 
// 👍 570 👎 0


package com.oddcc.leetcode.editor.cn;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
//        System.out.println(solution.strStr("hello", "ll"));
//        System.out.println(solution.strStr("aaaaa", "bba"));
//        System.out.println(solution.strStr("a", ""));
        System.out.println(solution.strStr("mississippi", "sippia"));
//        System.out.println(solution.strStr("aaa", "aaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack.equals(needle)) return 0;
            if (needle.isEmpty()) return 0;
            if (needle.length() > haystack.length()) return -1;
            if (haystack.isEmpty()) return -1;
            char[] stackArray = haystack.toCharArray();
            char[] needleArray = needle.toCharArray();
            // 找第一个所在
            int result = -1;
            for (int i = 0; i < stackArray.length; i++) {
                if (stackArray[i] == needleArray[0]) {
                    if (isMatch(stackArray, needleArray, i)) {
                        result = i;
                        break;
                    }
                }
            }
            return result;
        }

        /**
         * 从a的start位置开始向后找b.length位，是否与b匹配
         * @param a
         * @param b
         * @param start
         * @return
         */
        private boolean isMatch(char[] a, char[] b, int start) {
            if (start > a.length - 1) return false;
            if (b.length > a.length - start) return false;
            for (int i = 0; i < b.length; i++) {
                if (a[i + start] != b[i]) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}