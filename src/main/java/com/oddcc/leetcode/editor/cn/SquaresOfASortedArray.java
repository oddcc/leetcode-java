package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
//        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
//        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3, -3, -3, -3})));
//        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{1, 2, 3, 4, 5})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，直接计算平方，然后排序
        // 思路2，一次遍历，两个指针，指针A指向负数，指针B指向>=0的最小值，每次插入一个新值时，比较A、B指针指向的数的绝对值，选用绝对值小的值插入，然后移动对应指针
        // 初始时用二分查找查>=0的最小值B，B-1就是A
        // 思路3，可以直接用两个指针指向头和尾，然后合并，如果是负数 -> 正数这样的数组，绝对值是大 -> 小 -> 大；而如果都是正数，也只需要一次遍历
        public int[] sortedSquares(int[] A) {
            int len = A.length;
            if (len == 0) return new int[0];
            if (len == 1) return new int[]{(int) Math.pow(A[0], 2)};
            int[] ans = new int[len];
            int a = 0;
            int b = len - 1;
            for (int i = len - 1; i >= 0; i--) {
                if (a == b) {
                    ans[i] = A[a] * A[a];
                    break;
                }
                int absA = A[a] * A[a];
                int absB = A[b] * A[b];
                if (absA > absB) {
                    ans[i] = absA;
                    a++;
                }
                else {
                    ans[i] = absB;
                    b--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}