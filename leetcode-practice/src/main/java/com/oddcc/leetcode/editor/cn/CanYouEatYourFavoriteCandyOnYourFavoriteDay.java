// 1744

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public static void main(String[] args) {
        Solution solution = new CanYouEatYourFavoriteCandyOnYourFavoriteDay().new Solution();
        System.out.println(Arrays.toString(solution.canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}})));
        System.out.println(Arrays.toString(solution.canEat(new int[]{5, 2, 6, 4, 1}, new int[][]{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，利用前缀和
    class Solution {
        public boolean[] canEat(int[] candiesCount, int[][] queries) {
            int len = candiesCount.length;
            long[] candyPre = new long[len];
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    candyPre[0] = candiesCount[0];
                }
                else {
                    candyPre[i] = candiesCount[i] + candyPre[i - 1];
                }
            }

            boolean[] ans = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int type = queries[i][0];
                int day = queries[i][1];
                int cap = queries[i][2];

                // 注意这里day+1，因为第0天也要吃糖
                long min = day + 1; // day天实际最少能吃多少糖
                long max = (long) (day + 1) * cap; // day天实际最多能吃多少糖
                long haveToEat = type == 0 ? 1 : candyPre[type - 1] + 1; // 要满足条件，理论上最少吃糖的量
                long noMoreThan = candyPre[type]; // 要满足条件，理论上最多吃糖的量

                // 两种情况不满足
                // 1，每天都吃一颗，依然在day天之前，把type糖吃完了
                // 2，每天都吃cap颗，截至到day天，还没吃完type-1糖
                ans[i] = !(min > noMoreThan || max < haveToEat);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}