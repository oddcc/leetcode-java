// 354

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(solution.maxEnvelopes(new int[][]{{1, 1}}));
        System.out.println(solution.maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));
        System.out.println(solution.maxEnvelopes(new int[][]{{10, 8}, {1, 12}, {6, 15}, {2, 18}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 不用考虑旋转的问题
        // 思路1，动态规划，dp[i]表示[0,i]这段之中，最多能套几个信封
        public int maxEnvelopes(int[][] envelopes) {
            int len = envelopes.length;
            if (len == 0) return 0;
            Arrays.sort(envelopes, (e1, e2) -> {
                if (e1[0] == e2[0]) return e1[1] - e2[1];
                return e1[0] - e2[0];
            });
            int[] dp = new int[len];
            Arrays.fill(dp, 1); // 对于每个位置来说，最少信封数是1（只有自己）
            for (int end = 0; end < len; end++) {
                for (int i = 0; i < end; i++) {
                    // 这里如果能套进去，就取其中最多信封的那个结果
                    if (valid(i, end, envelopes)) {
                        dp[end] = Math.max(dp[end], dp[i] + 1);
                    }
                }
            }
            int ans = 0;
            for (int i: dp) ans = Math.max(ans, i);
            return ans;
        }

        private boolean valid(int current, int next, int[][] e) {
            return e[current][0] < e[next][0] && e[current][1] < e[next][1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}