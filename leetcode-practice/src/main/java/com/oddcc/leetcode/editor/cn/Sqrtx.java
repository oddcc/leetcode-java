// 69
package com.oddcc.leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
        System.out.println(solution.mySqrt(6));
        System.out.println(solution.mySqrt(0));
        System.out.println(solution.mySqrt(3));
        System.out.println(solution.mySqrt(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，枚举，设置一个足够小的步进值，在0到x之间遍历
        // 思路2，二分查找，在0到x之间二分查找，查找的应该是0到x之间的数字i，i是最后一个满足i*i < x的值
        public int mySqrt(int x) {
            return (int) search(0, x, x);
        }

        private long search(long left, long right, long tar) {
            if (left >= right) {
                if (left * left <= tar) return left;
                return -1;
            }
            long mid = (right - left) / 2 + left;
            // if (mid * mid == tar) return mid;
            // 说明大了，要找左半部分
            if (mid * mid > tar) {
                return search(left, mid - 1, tar);
            }
            // 说明小了，要找右半部分，但不能排除mid，因为mid可能是答案
            else {
                long i = search(mid + 1, right, tar);
                if (i == -1) return mid;
                return i;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}