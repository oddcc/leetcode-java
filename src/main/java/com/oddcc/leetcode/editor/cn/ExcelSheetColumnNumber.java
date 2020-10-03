//Given a column title as appear in an Excel sheet, return its corresponding col
//umn number. 
//
// For example: 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// Example 1: 
//
// 
//Input: "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: "ZY"
//Output: 701
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 7 
// s consists only of uppercase English letters. 
// s is between "A" and "FXSHRXW". 
// 
// Related Topics 数学 
// 👍 175 👎 0


package com.oddcc.leetcode.editor.cn;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("ZY"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 跟168题正好相反，从字母到数字的计算比较简单，跟普通的进制转换没有区别
        public int titleToNumber(String s) {
            int total = 0;
            for (int i = 0; i <= s.length() - 1; i++) {
                int a = s.charAt(i) - 'A' + 1;
                int b = (int) Math.pow(26, s.length() - i - 1);
                total += a * b;
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}