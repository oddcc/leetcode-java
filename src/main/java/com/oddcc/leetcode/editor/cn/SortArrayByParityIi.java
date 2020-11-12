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
        // 思路1，基于思路1，每有一个错位的奇数，就有一个错位的偶数对应，可以考虑双指针从两边同时遍历；由于分奇偶两种情况，可以考虑遍历两次
        public int[] sortArrayByParityII(int[] A) {
            int oL = 0;
            int oR = A.length - 1;
            // 处理非法的奇数
            while (oL < oR) {
                boolean done = false;
                while (!(isOdd(A[oL]) && isEven(oL))) {
                    oL++;
                    if (oL >= A.length) {
                        done = true;
                        break;
                    }
                }
                while (!(isEven(A[oR]) && isOdd(oR))) {
                    oR--;
                    if (oR < 0) {
                        done = true;
                        break;
                    }
                }
                if (done) break;
                swap(A, oL, oR);
            }
            int eL = 0;
            int eR = A.length - 1;
            // 处理非法的偶数
            while (eL < eR) {
                boolean done = false;
                while (!(isEven(A[eL]) && isOdd(eL))) {
                    eL++;
                    if (eL >= A.length) {
                        done = true;
                        break;
                    }
                }
                while (!(isOdd(A[eR]) && isEven(eR))) {
                    eR--;
                    if (eR < 0) {
                        done = true;
                        break;
                    }
                }
                if (done) break;
                swap(A, eL, eR);
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