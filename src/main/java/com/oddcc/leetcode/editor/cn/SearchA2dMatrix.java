// 74

package com.oddcc.leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        }, 3));
        System.out.println(solution.searchMatrix(new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        }, 13));
        System.out.println(solution.searchMatrix(new int[][]{
                {1}
        }, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，逻辑上转换为一维数组，二分查找
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int i = search(matrix, 0, m * n - 1, target);
            return i != -1;
        }

        private int search(int[][] matrix, int left, int right, int target) {
            if (!valid(matrix, left, right)) return -1;
            if (left >= right && get(matrix, left) != target) return -1;
            int mid = (right - left) / 2 + left;
            if (get(matrix, mid) == target) {
                return mid;
            }
            if (get(matrix, mid) > target) {
                return search(matrix, left, mid - 1, target);
            }
            return search(matrix, mid + 1, right, target);
        }

        private int get(int[][] matrix, int i) {
            int n = matrix[0].length;
            int x = i / n;
            int y = i - x * n;
            return matrix[x][y];
        }

        private boolean valid(int[][] matrix, int left, int right) {
            int total = matrix.length * matrix[0].length - 1;
            return left >= 0 && left <= total && right >= 0 && right <= total;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}