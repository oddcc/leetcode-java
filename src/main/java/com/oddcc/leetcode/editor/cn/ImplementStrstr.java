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
        System.out.println(solution.strStr("mississippi", "sippi"));
        System.out.println(solution.strStr("", ""));
//        System.out.println(solution.strStr("aaa", "aaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack.equals(needle)) return 0;
            if (needle.isEmpty()) return 0;
            if (haystack.isEmpty()) return -1;
            if (haystack.length() < needle.length()) return -1;

            int result = -1;
            // 如果剩下的都不够needl那么长了，就不用判断了
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int n = 0;
                    for (int h = 0; h < needle.length(); h++) {
                        // 相同的话，移动两个指针，不同的直接放弃
                        if (haystack.charAt(h + i) == needle.charAt(n)) {
                            n++;
                        } else {
                            break;
                        }
                    }
                    // 如果最后指针n停留在最后，说明找到了
                    if (n == needle.length()) {
                        result = i;
                        break;
                    }
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}