// 888

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FairCandySwap {
    public static void main(String[] args) {
        Solution solution = new FairCandySwap().new Solution();
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{35, 17, 4, 24, 10}, new int[]{63, 21})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，排序，计算相差多少，然后找到符合条件的值
        public int[] fairCandySwap(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);
            int want = (Arrays.stream(A).sum() - Arrays.stream(B).sum()) / 2;
            // A的和大
            if (want > 0) {
                int a = A.length - 1;
                while (a >= 0) {
                    int b = B.length - 1;
                    while (b >= 0) {
                        if (A[a] - want > B[b]) break; // 继续遍历，B[b]会越来越小
                        if (A[a] - want == B[b]) {
                            return new int[]{A[a], B[b]};
                        }
                        b--;
                    }
                    a--;
                }
            }
            // B的和大
            else {
                want = -want;
                int b = B.length - 1;
                while (b >= 0) {
                    int a = A.length - 1;
                    while (a >= 0) {
                        if (B[b] - want > A[a]) break; // 剪枝
                        if (B[b] - want == A[a]) {
                            return new int[]{A[a], B[b]};
                        }
                        a--;
                    }
                    b--;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}