// 171

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
            char[] chars = s.toCharArray();
            for (int i = 0; i <= chars.length - 1; i++) {
                int a = chars[i] - 'A' + 1;
                total = 26 * total + a;
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}