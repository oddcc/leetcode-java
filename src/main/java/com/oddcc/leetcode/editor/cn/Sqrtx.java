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
        System.out.println(solution.mySqrt(6));
        System.out.println(solution.mySqrt(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 0 <= sqrt(x) < x
        public int mySqrt(int x) {
            long left = 0;
            long right = x;
            long r = 0;
            while (left <= right) {
                long mid = (right - left) / 2 + left;
                if (mid * mid <= x) {
                    r = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return (int) r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}