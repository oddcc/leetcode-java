// 888

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        // 思路2，哈希表
        public int[] fairCandySwap(int[] A, int[] B) {
            Set<Integer> setA = new HashSet<>();
            int sumA = 0;
            for (int i : A) {
                setA.add(i);
                sumA += i;
            }
            Set<Integer> setB = new HashSet<>();
            int sumB = 0;
            for (int i : B) {
                setB.add(i);
                sumB += i;
            }
            int want = (sumA - sumB) / 2;
            // A的和大
            if (want > 0) {
                for (int a : A) {
                    if (setB.contains(a - want)) {
                        return new int[]{a, a - want};
                    }
                }
            }
            // B的和大
            else {
                want = -want;
                for (int b : B) {
                    if (setA.contains(b - want)) {
                        return new int[]{b - want, b};
                    }
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}