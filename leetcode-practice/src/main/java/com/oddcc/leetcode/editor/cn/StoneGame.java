// 877

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StoneGame {
    public static void main(String[] args) {
        Solution solution = new StoneGame().new Solution();
        System.out.println(solution.stoneGame(new int[]{5, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，分治+递归，超时
    // 思路2，加缓存优化思路1
    class Solution {
        private Map<Integer, Boolean> cache = new HashMap<>();

        public boolean stoneGame(int[] piles) {
            int len = piles.length;
            return tryPick(piles[0], 0, 1, len - 1, piles, 0) ||
                    tryPick(0, piles[0], 1, len - 1, piles, 1) ||
                    tryPick(piles[len - 1], 0, 0, len - 2, piles, 0) ||
                    tryPick(0, piles[len - 1], 0, len - 2, piles, 1);
        }

        /**
         *
         * @param alex alex当前石头数
         * @param lee lee当前石头数
         * @param start 可选石头左边界
         * @param end 可选石头右边界
         * @param piles
         * @param alexTurn 是否该alex选 1-该,0-不该
         * @return alex是否能赢
         */
        private boolean tryPick(int alex, int lee, int start, int end, int[] piles, int alexTurn) {
            int key = Arrays.hashCode(new int[]{start, end, alexTurn});
            if (cache.containsKey(key)) return cache.get(key);
            // 当start > end时，说明石头选完了
            if (start > end) {
                boolean res = alex > lee;
                cache.put(key, res);
                return res;
            }
            // alex 选的情况
            if (alexTurn == 1) {
                boolean res = tryPick(alex + piles[start], lee, start + 1, end, piles, 0) ||
                        tryPick(alex + piles[end], lee, start, end - 1, piles, 0);
                cache.put(key, res);
                return res;
            }
            // lee 选的情况
            else {
                boolean res = tryPick(alex, lee + piles[start], start + 1, end, piles, 1) ||
                        tryPick(alex, lee + piles[end], start, end - 1, piles, 1);
                cache.put(key, res);
                return res;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}