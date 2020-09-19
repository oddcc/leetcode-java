//Given a string s consists of upper/lower-case alphabets and empty space charac
//ters ' ', return the length of last word (last word means the last appearing wor
//d if we loop from left to right) in the string. 
//
// If the last word does not exist, return 0. 
//
// Note: A word is defined as a maximal substring consisting of non-space charac
//ters only. 
//
// Example: 
//
// 
//Input: "Hello World"
//Output: 5
// 
//
// 
// Related Topics 字符串 
// 👍 242 👎 0


package com.oddcc.leetcode.editor.cn;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("a "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s.isEmpty()) return 0;
            int currentLength = 0;
            int result = 0;
            boolean lastIsSpace = true;
            for (int i = 0; i <= s.length(); i++) {
                if (i == s.length()) {
                    result = currentLength;
                    break;
                }
                if (s.charAt(i) == ' ') {
                    result = currentLength;
                    lastIsSpace = true;
                }
                else {
                    if (lastIsSpace) {
                        currentLength = 1;
                    } else {
                        currentLength++;
                    }
                    lastIsSpace = false;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}