// 435

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 3}, {2, 3}, {3, 4}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 3}, {2, 4}, {3, 4}, {1, 4}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，先处理尽量小的区间，当新加入一个区间时，如果跟前一个区间重合了，则丢弃新的区间
        // 为什么是右升序？
        // 如何证明这样做，每步都是最优解？
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length < 2) return 0;
            Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
            int ans = 0;
            int[] pre = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] current = intervals[i];
                if (current[0] < pre[1]) {
                    ans++;
                }
                else {
                    pre = current;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}