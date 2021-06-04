// 168
package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
//        System.out.println(solution.convertToTitle(701));
//        System.out.println(solution.convertToTitle(702));
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

        // 没有0，不是一般的进制转换问题
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
            boolean carry = stack.peekLast() == 0;
            while (!stack.isEmpty()) {
                int i = stack.pop();
                if (stack.isEmpty() && i == 0 && carry) break;
                if (i == 0) {
                    sb.append(chars[26]);
                    carry = true;
                }
                else {
                    if (carry) {
                        int i2 = i - 1;
                        if (i2 == 0) {
                            sb.append(chars[26]);
                        }
                        else {
                            sb.append(chars[i2]);
                            carry = false;
                        }
                    } else {
                        sb.append(chars[i]);
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}