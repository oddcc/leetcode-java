//Given a non-empty array of digits representing a non-negative integer, increme
//nt one to the integer. 
//
// The digits are stored such that the most significant digit is at the head of 
//the list, and each element in the array contains a single digit. 
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// 
//
// Example 3: 
//
// 
//Input: digits = [0]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 546 👎 0


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