// 58

package com.oddcc.leetcode.editor.cn;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("a "));
        System.out.println(solution.lengthOfLastWord("    "));
        System.out.println(solution.lengthOfLastWord(""));
        System.out.println(solution.lengthOfLastWord("hello world "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s.isEmpty()) return 0;
            int currentLength = 0;
            int result = 0;
            int l = s.length();
            boolean lastNotSpace = false;
            for (int i = l - 1; i >= -1; i--) {
                if (i == -1) {
                    result = currentLength;
                    break;
                }
                if (s.charAt(i) == ' ') {
                    if (lastNotSpace) {
                        result = currentLength;
                        break;
                    }
                }
                else {
                    if (lastNotSpace) {
                        currentLength++;
                    } else {
                        currentLength = 1;
                    }
                    lastNotSpace = true;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}