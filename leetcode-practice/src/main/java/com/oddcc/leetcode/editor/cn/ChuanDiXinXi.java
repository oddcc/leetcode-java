// LCP 07

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class ChuanDiXinXi {
    public static void main(String[] args) {
        Solution solution = new ChuanDiXinXi().new Solution();
        System.out.println(solution.numWays(5, new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，直接模拟，单向，可重复
    class Solution {
        public int numWays(int n, int[][] relation, int k) {
            Map<Integer, List<Integer>> cache = new HashMap<>();
            for (int[] r : relation) {
                if (cache.containsKey(r[0])) {
                    cache.get(r[0]).add(r[1]);
                }
                else {
                    List<Integer> l = new ArrayList<>();
                    l.add(r[1]);
                    cache.put(r[0], l);
                }
            }

            Deque<Integer> queue = new LinkedList<>();
            queue.addFirst(0);
            for (int i = 0; i < k; i++) {
                int len = queue.size();
                for (int c = 0; c < len; c++) {
                    int start = queue.removeLast();
                    if (!cache.containsKey(start)) continue;
                    for (int end: cache.get(start)) {
                        queue.addFirst(end);
                    }
                }
            }

            int ans = 0;
            for (int i: queue) {
                if (i == n-1) ans++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}