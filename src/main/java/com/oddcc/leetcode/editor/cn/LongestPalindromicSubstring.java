//Given a string s, return the longest palindromic substring in s.
//
//
// Example 1:
//
//
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: s = "cbbd"
//Output: "bb"
//
//
// Example 3:
//
//
//Input: s = "a"
//Output: "a"
//
//
// Example 4:
//
//
//Input: s = "ac"
//Output: "a"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consist of only digits and English letters (lower-case and/or upper-case),
//
//
// Related Topics 字符串 动态规划
// 👍 2754 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 假设我们有一个方法f(x, y) 可以告诉我们，[x,y]这个子串是不是一个回文串，那么我们就可以有以下代码逻辑
        public String longestPalindrome(String s) {
            if (s.isEmpty()) return "";
            char[] chars = s.toCharArray();
            int maxLength = 0;
            int left = 0;
            int right = 0;
            for (int i = 0; i < chars.length; i++) {
                for (int j = i; j < chars.length; j++) {
                    if (isPalindromic(chars, i, j)) {
                        int length = j - i + 1;
                        if (length > maxLength) {
                            maxLength = length;
                            left = i;
                            right = j;
                        }
                    }
                }
            }
            return s.substring(left, right + 1);
        }

        // 判断一个子串是不是回文，是有递归的解法的，但递归会产生大量的重复运算，可以考虑动态规划
        // 存储状态我们用0表示没结果、1表示true、2表示false
        private int[][] cache = null;

        private boolean isPalindromic(char[] chars, int i, int j) {
            if (cache == null) {
                cache = new int[chars.length][chars.length];
                for (int[] ints : cache) {
                    Arrays.fill(ints, 0);
                }
            }
            if (i >= j) return true;
            boolean equal = chars[i] == chars[j];
            if (cache[i + 1][j - 1] == 0) {
                cache[i + 1][j - 1] = isPalindromic(chars, i + 1, j - 1) ? 1 : 2;
            }
            return equal && cache[i + 1][j - 1] == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}