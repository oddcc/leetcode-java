//Given two binary strings, return their sum (also a binary string). 
//
// The input strings are both non-empty and contains only characters 1 or 0. 
//
// Example 1: 
//
// 
//Input: a = "11", b = "1"
//Output: "100" 
//
// Example 2: 
//
// 
//Input: a = "1010", b = "1011"
//Output: "10101" 
//
// 
// Constraints: 
//
// 
// Each string consists only of '0' or '1' characters. 
// 1 <= a.length, b.length <= 10^4 
// Each string is either "0" or doesn't contain any leading zero. 
// 
// Related Topics 数学 字符串 
// 👍 475 👎 0


package com.oddcc.leetcode.editor.cn;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
//        System.out.println(solution.addBinary("11", "1"));
//        System.out.println(solution.addBinary("11", "11"));
//        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("0", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int al = a.length();
            int bl = b.length();
            int length = Math.max(al, bl);
            StringBuilder sb = new StringBuilder();
            int increment = 0;
            for (int i = 0; i < length; i++) {
                int addA = getAdd(a, a.length() - i - 1);
                int addB = getAdd(b, b.length() - i - 1);
                int sum = addA + addB + increment;
                if (sum >= 2) {
                    increment = 1;
                    sb.append(sum - 2);
                } else {
                    increment = 0;
                    sb.append(sum);
                }
            }
            if (increment != 0) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }

        // 从字符串中取出i位置的数字，如果i超过了索引范围则返回0
        private int getAdd(String str, int i) {
            if (i >= 0 && i < str.length()) {
                return Integer.parseInt(str.substring(i, i + 1));
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}