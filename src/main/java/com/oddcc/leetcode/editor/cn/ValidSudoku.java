// 36
package com.oddcc.leetcode.editor.cn;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
//        char[][] b1 = new char[][]{
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
//                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] b1 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(b1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历，挨个验证，如果结束没问题就是true，否则false；行：9行9个数字，boolean[i][j]表示j字符在第i行是否已存在；列，同理；方块，同理
        // 字符如何映射到位置？c - '0' -> 0~9
        public boolean isValidSudoku(char[][] board) {
            boolean[][] rowCache = new boolean[9][10];
            boolean[][] columnCache = new boolean[9][10];
            boolean[][] blockCache = new boolean[9][10];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 如果在行、列、方块中都不重复，则往下进行，且标记相应位置为存在
                    // 如果在行、列、方块中存在，则返回false
                    char c = board[i][j];
                    if (c == '.') continue;
                    if (existsInRow(c - '0', i, rowCache)) {
                        return false;
                    }
                    else {
                        rowCache[i][c - '0'] = true;
                    }
                    if (existsInColumn(c - '0', j, columnCache)) {
                        return false;
                    }
                    else {
                        columnCache[j][c - '0'] = true;
                    }
                    if (existsInBlock(c - '0', convertToBlockNo(i, j), blockCache)) {
                        return false;
                    }
                    else {
                        blockCache[convertToBlockNo(i, j)][c - '0'] = true;
                    }
                }
            }
            return true;
        }

        private boolean existsInBlock(int c, int convertToBlockNo, boolean[][] blockCache) {
            return blockCache[convertToBlockNo][c];
        }

        private int convertToBlockNo(int i, int j) {
            if (i <= 2) {
                if (j <= 2) return 0;
                if (j <= 5) return 1;
                if (j <= 8) return 2;
            }
            if (i <= 5) {
                if (j <= 2) return 3;
                if (j <= 5) return 4;
                if (j <= 8) return 5;
            }
            if (i <= 8) {
                if (j <= 2) return 6;
                if (j <= 5) return 7;
                if (j <= 8) return 8;
            }
            return -1;
        }

        private boolean existsInColumn(int c, int j, boolean[][] columnCache) {
            return columnCache[j][c];
        }

        private boolean existsInRow(int c, int i, boolean[][] rowCache) {
            return rowCache[i][c];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}