package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new SortIntegersByTheNumberOf1Bits().new Solution();
        System.out.println(Arrays.toString(solution.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
//        System.out.println(Arrays.toString(solution.sortByBits(new int[]{64, 1024, 512, 256, 128, 32, 16, 8, 4, 2, 1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortByBits(int[] arr) {
            List<Integer> arrList = new ArrayList<>();
            for (int i : arr) {
                arrList.add(i);
            }
            arrList.sort((x, y) -> {
                int sub = countOnes(x) - countOnes(y);
                return sub == 0 ? x - y : sub;
            });
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arrList.get(i);
            }
            return arr;
        }

        private int countOnes(int x) {
            int count = 0;
            while (x > 0) {
                count += x & 1;
                x >>= 1;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}