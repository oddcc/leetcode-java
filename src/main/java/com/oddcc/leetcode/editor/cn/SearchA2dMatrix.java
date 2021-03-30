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
            int ans = -1;
            int left = 0;
            int right = m * n - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (get(matrix, mid) > target) {
                    right = mid - 1;
                } else if (get(matrix, mid) < target) {
                    left = mid + 1;
                } else {
                    ans = mid;
                    break;
                }
            }
            return ans != -1;
        }

        private int get(int[][] matrix, int i) {
            int n = matrix[0].length;
            int x = i / n;
            int y = i - x * n;
            return matrix[x][y];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}