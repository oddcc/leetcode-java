// 48
package com.oddcc.leetcode.editor.cn;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
//        int[][] m = new int[][]{{1, 2}, {3, 4}};
//        int[][] m = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        showMatrix(m);
        System.out.println("============");
        solution.rotate(m);
        showMatrix(m);
    }

    public static void showMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%-2d ", m[i][j]);
            }
            System.out.print("\n");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 手动画几个交换流程可以发现，如果每行有n个元素，元素索引为[r,c]，那么交换的规则是[r,c] -> [c,n-r-1]
        // 一个元素要变换位置，应该包含4次交换
        // 交换的元素都在同一层上
        // 如果每行有n个元素，则矩阵的层数为n/2层（n为偶数）或n/2 + 1层（n为奇数）
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int layer = n % 2 == 0 ? (n / 2) : (n / 2 + 1); // 这个矩阵的层数
            for (int i = 0; i < layer; i++) {
                rotate(matrix, i);
            }
        }

        private void rotate(int[][] matrix, int layer) {
            int n = matrix.length;
            int layerLen = n - layer * 2 - 1; // 本层有几个元素要交换，最外面为0层
            // 迭代要交换的元素，元素为[layer, layer] ~ [layer, layer + layerLen - 1]
            for (int i = layer; i < layer + layerLen; i++) {
                // 交换的元素为[layer, i]
                // 一个元素要经历4次交换
                int x = layer;
                int y = i;
                int tmp1 = Integer.MAX_VALUE;
                int tmp2 = tmp1;
                for (int c = 0; c < 4; c++) {
                    int tX = y;
                    int tY = n - x - 1;
                    if (tmp1 == Integer.MAX_VALUE) tmp1 = matrix[x][y];
                    tmp2 = matrix[tX][tY];
                    matrix[tX][tY] = tmp1;
                    tmp1 = tmp2;
                    x = tX;
                    y = tY;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}