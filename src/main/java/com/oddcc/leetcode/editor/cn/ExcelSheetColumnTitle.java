//Given a positive integer, return its corresponding column title as appear in a
//n Excel sheet. 
//
// For example: 
//
// 
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "A"
// 
//
// Example 2: 
//
//
//Input: 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: 701
//Output: "ZY"
// Related Topics 数学 
// 👍 271 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
//        System.out.println(solution.convertToTitle(701));
//        System.out.println(solution.convertToTitle(1));
//        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(52));
//        System.out.println(solution.convertToTitle(780));
//        System.out.println(solution.convertToTitle(260));
//        System.out.println(solution.convertToTitle(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char[] chars = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        // 没有0，不是进制转换的问题
        public String convertToTitle(int n) {
            Deque<Integer> stack = new LinkedList<>();
            while (n > 26) {
                int remain = Math.floorMod(n, 26);
                int divide = n / 26;
                stack.push(remain);
                n = divide;
            }
            stack.push(n);
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(chars[stack.pop()]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}