//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// s consists only of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 
// 👍 278 👎 0


package com.oddcc.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
//        System.out.println(solution.isPalindrome(""));
//        System.out.println(solution.isPalindrome("a"));
//        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("0P"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 仅判断字母，不区分大小写
        public boolean isPalindrome(String s) {
            if (s.length() <= 1) return true;
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (!isAlphanumeric(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!isAlphanumeric(s.charAt(right))) {
                    right--;
                    continue;
                }
                if (isSame(s.charAt(left), s.charAt(right))) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isSame(char c1, char c2) {
            int sub = 'a' - 'A';
            if (isLetter(c1) && isLetter(c2)) {
                return (c1 - c2 == 0) || Math.abs(c1 - c2) == sub;
            }
            return c1 - c2 == 0;
        }

        private boolean isAlphanumeric(char c) {
            return isLetter(c) || isNum(c);
        }

        private boolean isNum(char c) {
            return (c >= '0' && c <= '9');
        }

        private boolean isLetter(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}