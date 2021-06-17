// 65

package com.oddcc.leetcode.editor.cn;

public class ValidNumber {
    public static void main(String[] args) {
        Solution solution = new ValidNumber().new Solution();
        System.out.println(solution.isNumber("-123.456e789"));
        System.out.println(solution.isNumber("95a54e53"));
        System.out.println(solution.isNumber("2e10"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            boolean num = false, exp = false, sign = false, dec = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') num = true;
                else if (c == 'e' || c == 'E')
                    if (exp || !num) return false;
                    else {
                        exp = true;
                        sign = false;
                        num = false;
                        dec = false;
                    }
                else if (c == '+' || c == '-')
                    if (sign || num || dec) return false;
                    else sign = true;
                else if (c == '.')
                    if (dec || exp) return false;
                    else dec = true;
                else return false;
            }
            return num;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}