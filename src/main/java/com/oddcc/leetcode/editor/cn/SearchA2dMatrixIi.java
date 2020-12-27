// 240

package com.oddcc.leetcode.editor.cn;

public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(solution.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，对每一行进行二分查找，时间复杂度O(N * logM)
        // 思路2，根据对角线进行搜索，每次要新搜索1行，1列；如果当前右下角的值小于要找的值，则直接进行下一个
        public boolean searchMatrix(int[][] matrix, int target) {
            // 左上角到右下角
            // 如果右边已经到头了，则向下移动，每次移动后新搜索一行
            // 如果下边已经到头了，则向右移动，每次移动后新搜索一列
            int x = 0;
            int y = 0;
            int width = matrix[0].length;
            int height = matrix.length;
            while (true) {
                if (matrix[x][y] < target) {
                    System.out.println("pass " + x + "," + y);
                }
                else {
                    System.out.format("search row %d,%d ~ %d,%d\n", x, 0, x, y);
                    if (searchRow(matrix, target, x, 0, y)) {
                        System.out.format("found at %d,%d ~ %d,%d\n", x, 0, x, y);
                        return true;
                    }
                    System.out.format("search column %d,%d ~ %d,%d\n", 0, y, x, y);
                    if (searchColumn(matrix, target, y, 0, x)) {
                        System.out.format("found at %d,%d ~ %d,%d\n", 0, y, x, y);
                        return true;
                    }
                }
                // 如果最后一个点搜完了，则结束
                if (x == height - 1 && y == width - 1) {
                    break;
                }
                // 如果x最大了，说明没有更多行了，下次只能搜右边的点
                if (x == height - 1) {
                    y++;
                }
                // 如果y最大了，说明没有更多列了，下次只能搜下面的点
                else if (y == width - 1) {
                    x++;
                }
                // 如果右边下边都有空间，则搜右下角的点
                else {
                    y++;
                    x++;
                }
            }
            return false;
        }

        // 二分查找，找的是第y列，0到x个元素
        private boolean searchColumn(int[][] matrix, int target, int y, int low, int high) {
            if (low >= high) {
                return matrix[low][y] == target;
            }
            int mid = low + (high - low) / 2;
            if (matrix[mid][y] == target) return true;
            if (matrix[mid][y] < target) {
                return searchColumn(matrix, target, y, mid + 1, high);
            }
            return searchColumn(matrix, target, y, 0, mid - 1);
        }

        // 二分查找，找的是第x行，0到y个元素
        private boolean searchRow(int[][] matrix, int target, int x, int low, int high) {
            int[] arr = matrix[x];
            if (low >= high) {
                return arr[low] == target;
            }
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) {
                return searchRow(matrix, target, x, mid + 1, high);
            }
            return searchRow(matrix, target, x, 0, mid - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}