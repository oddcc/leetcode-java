// 2038

package com.oddcc.leetcode.editor.cn;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public static void main(String[] args) {
        Solution solution = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor().new Solution();
        System.out.println(solution.winnerOfGame("AAABABB"));
        System.out.println(solution.winnerOfGame("AA"));
        System.out.println(solution.winnerOfGame("ABBBBBBBAAA"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean winnerOfGame(String colors) {
            int aCnt = 0;
            int bCnt = 0;
            int continueACnt = 0;
            int continueBCnt = 0;
            for (Character c: colors.toCharArray()) {
                if (c == 'A') {
                    continueACnt++;
                    if (continueACnt >= 3) {
                        aCnt++;
                    }
                    continueBCnt = 0;
                } else {
                    continueBCnt++;
                    if (continueBCnt >= 3) {
                        bCnt++;
                    }
                    continueACnt = 0;
                }
            }
            return aCnt > bCnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}