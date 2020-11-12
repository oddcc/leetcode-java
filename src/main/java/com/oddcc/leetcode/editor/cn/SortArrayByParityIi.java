// 922

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SortArrayByParityIi {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParityIi().new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(solution.sortArrayByParityII(new int[]{3, 0, 4, 0, 2, 1, 3, 1, 3, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，双指针，从左遍历，如果碰到不符合的（比如A[i]是偶数，i是奇数或A[i]是奇数，i是偶数），就往后找一个不符合的，并交换，因为奇数偶数是一半一半，所以一次交换会减少两个不符合的情况
        // 思路2，基于思路1，每有一个错位的奇数，就有一个错位的偶数对应，可以考虑双指针从两边同时遍历；由于分奇偶两种情况，可以考虑遍历两次
        // 思路3，基于思路1优化，当找对应位置的时候，因为只要找奇数或偶数位置，每次指针移动可以移动2位
        // 思路4，奇数指针和偶数指针
        public int[] sortArrayByParityII(int[] A) {
            int even = 0;
            int odd = 1;
            while (even < A.length && odd < A.length) {
                while (even < A.length && !isOdd(A[even])) {
                    even += 2;
                }
                while (odd < A.length && !isEven(A[odd])) {
                    odd += 2;
                }
                if (odd < A.length && even < A.length) swap(A, odd, even);
            }
            return A;
        }

        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        private boolean isEven(int i) {
            return i % 2 == 0;
        }

        private boolean isOdd(int i) {
            return i % 2 != 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}