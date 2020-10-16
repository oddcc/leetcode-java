package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
//        int[][] a1 = new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}};
        int[][] a1 = new int[][]{{1, 4}, {4, 5}};
        solution.merge(a1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目没提到区间是递增的，如果是递增的，就可以从头合并一遍，后面的区间合并，只要考虑前一个区间就可以
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            Deque<int[]> ansStack = new LinkedList<>();
            for (int[] b : intervals) {
                if (ansStack.isEmpty()) {
                    ansStack.push(b);
                    continue;
                }
                int[] a = ansStack.pop();
                if (overlap(a, b)) {
                    ansStack.push(new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])});
                }
                else {
                    ansStack.push(a);
                    ansStack.push(b);
                }
            }
            int[][] des = new int[ansStack.size()][2];
            for (int i = 0; i < des.length; i++) {
                int[] t = ansStack.removeLast();
                for (int j = 0; j < 2; j++) {
                    des[i][j] = t[j];
                }
            }
            return des;
        }

        private boolean overlap(int[] a, int[] b) {
            if (a == null || b == null) return false;
            int aL = a[0];
            int aH = a[1];
            int bL = b[0];
            int bH = b[1];
            return (bL >= aL && bL <= aH) || (bH >= aL && bH <= aH);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}