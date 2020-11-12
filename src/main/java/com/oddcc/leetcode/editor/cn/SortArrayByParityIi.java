// 922

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SortArrayByParityIi {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParityIi().new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，双指针，从左遍历，如果碰到不符合的（比如A[i]是偶数，i是奇数或A[i]是奇数，i是偶数），就往后找一个不符合的，并交换，因为奇数偶数是一半一半，所以一次交换会减少两个不符合的情况
        public int[] sortArrayByParityII(int[] A) {
            for (int i = 0; i < A.length; i++) {
                // 找奇数
                if (isEven(A[i]) && isOdd(i)) {
                    for (int j = i + 1; j < A.length; j++) {
                        if (isOdd(A[j]) && isEven(j)) {
                            swap(A, i, j);
                            break;
                        }
                    }
                }
                // 找偶数
                if (isOdd(A[i]) && isEven(i)) {
                    for (int j = i + 1; j < A.length; j++) {
                        if (isEven(A[j]) && isOdd(j)) {
                            swap(A, i, j);
                            break;
                        }
                    }
                }
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