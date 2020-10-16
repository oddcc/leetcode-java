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
            List<List<Integer>> sorted = sort(intervals);
            Deque<List<Integer>> ansStack = new LinkedList<>();
            for (List<Integer> b : sorted) {
                if (ansStack.isEmpty()) {
                    ansStack.push(b);
                    continue;
                }
                List<Integer> a = ansStack.pop();
                if (overlap(a, b)) {
                    List<Integer> merged = Arrays.asList(Math.min(a.get(0), b.get(0)), Math.max(a.get(1), b.get(1)));
                    ansStack.push(merged);
                }
                else {
                    ansStack.push(a);
                    ansStack.push(b);
                }
            }
            int[][] des = new int[ansStack.size()][2];
            for (int i = 0; i < des.length; i++) {
                List<Integer> t = ansStack.removeLast();
                for (int j = 0; j < 2; j++) {
                    des[i][j] = t.get(j);
                }
            }
            return des;
        }

        private boolean overlap(List<Integer> a, List<Integer> b) {
            if (a == null || b == null) return false;
            int aL = a.get(0);
            int aH = a.get(1);
            int bL = b.get(0);
            int bH = b.get(1);
            return (bL >= aL && bL <= aH) || (bH >= aL && bH <= aH);
        }

        private List<List<Integer>> sort(int[][] src) {
            List<List<Integer>> ans = new ArrayList<>(src.length);
            for (int[] a : src) {
                List<Integer> t = new ArrayList<>(2);
                for (int i : a) {
                    t.add(i);
                }
                ans.add(t);
            }
            ans.sort(Comparator.comparing(a -> a.get(0)));
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}