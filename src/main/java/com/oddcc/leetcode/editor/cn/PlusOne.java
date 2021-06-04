// 66
package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9,9})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            // 从最后一位开始加1，所以进位开始是1
            int increment = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int sum = digits[i] + increment;
                if (sum >= 10) {
                    increment = 1;
                    digits[i] = sum - 10;
                } else {
                    increment = 0;
                    digits[i] = sum;
                    break;
                }
            }
            if (increment != 0) {
                int[] r = Arrays.copyOf(digits, digits.length + 1);
                r[0] = 1;
                return r;
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}