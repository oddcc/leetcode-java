//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
//gative integer. 
//
// Since the return type is an integer, the decimal digits are truncated and onl
//y the integer part of the result is returned. 
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics 数学 二分查找 
// 👍 506 👎 0


package com.oddcc.leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 直接从1枚举会超时
        // i * i会溢出
        public int mySqrt(int x) {
            if (x <= 1) return x;
            long i = 1;
            // 不满足条件时，i *= 2，退出循环后，再从i *= 2的结果中往回找
            while (i * i < x) {
                i *= 2;
            }
            while (i * i > x) {
                i--;
            }
            return (int) i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}