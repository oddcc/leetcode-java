// 877

package com.oddcc.leetcode.editor.cn;

public class StoneGame {
    public static void main(String[] args) {
        Solution solution = new StoneGame().new Solution();
        System.out.println(solution.stoneGame(new int[]{5, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，分治+递归，超时
    class Solution {
        public boolean stoneGame(int[] piles) {
            int len = piles.length;
            return tryPick(piles[0], 0, 1, len - 1, piles, false) ||
                    tryPick(0, piles[0], 1, len - 1, piles, true) ||
                    tryPick(piles[len - 1], 0, 0, len - 2, piles, false) ||
                    tryPick(0, piles[len - 1], 0, len - 2, piles, true);
        }

        /**
         *
         * @param alex alex当前石头数
         * @param lee lee当前石头数
         * @param start 可选石头左边界
         * @param end 可选石头右边界
         * @param piles
         * @param alexTurn 是否该alex选
         * @return alex是否能赢
         */
        private boolean tryPick(int alex, int lee, int start, int end, int[] piles, boolean alexTurn) {
            // 当start > end时，说明石头选完了
            if (start > end) {
                return alex > lee;
            }
            // alex 选的情况
            if (alexTurn) {
                return tryPick(alex + piles[start], lee, start + 1, end, piles, false) ||
                        tryPick(alex + piles[end], lee, start, end - 1, piles, false);
            }
            // lee 选的情况
            else {
                return tryPick(alex, lee + piles[start], start + 1, end, piles, true) ||
                        tryPick(alex, lee + piles[end], start, end - 1, piles, true);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}