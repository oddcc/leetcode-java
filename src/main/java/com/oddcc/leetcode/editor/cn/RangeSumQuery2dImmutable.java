// 304

package com.oddcc.leetcode.editor.cn;

public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        RangeSumQuery2dImmutable o = new RangeSumQuery2dImmutable();
        o.test();
    }

    private void test() {
        NumMatrix matrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
        System.out.println(matrix.sumRegion(1, 1, 2, 2));
        System.out.println(matrix.sumRegion(1, 2, 2, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        // 看题目的意思，非常像是前缀和数组的翻版
        // 实际上也确实如此，一个矩形内所有元素的和，可以拆成若干行的元素的和，而行内某段元素的和可以直接用前缀和数组实现
        private int[][] preSumMatrix;
        private int m;
        private int n;

        public NumMatrix(int[][] matrix) {
            this.m = matrix.length;
            if (this.m == 0) return;
            this.n = matrix[0].length;
            int[][] preSum = new int[this.m][this.n];
            for (int i = 0; i < this.m; i++) {
                int[] preSumRow = new int[n];
                for (int j = 0; j < this.n; j++) {
                    if (j == 0) {
                        preSumRow[j] = matrix[i][j];
                    }
                    else {
                        preSumRow[j] = preSumRow[j - 1] + matrix[i][j];
                    }
                }
                preSum[i] = preSumRow;
            }
            this.preSumMatrix = preSum;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (this.m == 0) return 0;
            if (row1 < 0 || row1 >= this.m || row2 < 0 || row2 >= this.m
                    || col1 < 0 || col1 >= this.n || col2 < 0 || col2 >= this.n)
                return 0;
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += this.preSumMatrix[i][col2] - (col1 - 1 >= 0 ? this.preSumMatrix[i][col1 - 1] : 0);
            }
            return sum;
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}