// 剑指 Offer 04

package com.oddcc.leetcode.editor.cn;

public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}},
                20));
        System.out.println(solution.findNumberIn2DArray(new int[][]{}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，二分查找+暴力法，按行进行二分查找，时间复杂度O(NlogM)
        // 思路2，矩阵旋转90度（哪个方向都行，就是从右上角或左下角出发），就可以看作一颗BST
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            if (matrix[0].length == 0) return false;
            // 从右上角出发
            int x = 0;
            int y = matrix[0].length - 1;
            while (valid(x, matrix.length) && valid(y, matrix[0].length)) {
                int n = matrix[x][y];
                if (n == target) return true;
                if (n < target) {
                    x++;
                }
                else {
                    y--;
                }
            }
            return false;
        }

        private boolean valid(int x, int limit) {
            return x >= 0 && x < limit;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}