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
        // 思路1，一个矩形内所有元素的和，可以拆成若干行的元素的和，而行内某段元素的和可以直接用前缀和数组实现
        // 思路2，优化思路1，如果pre[i][j]表示[0,0]~[i,j]的矩形内的元素的和，那么对于题目的[row1,col1]~[row2,col2]
        // 就有ans = pre[row2][col2] - pre[row1 - 1][col2] - pre[row2][col1 - 1] + pre[row1 - 1][col1 - 1]
        // 关于为什么，可以注意一下上面的四个部分分别是哪些矩形，画个图就很容易明白
        // 构造pre数组时，也是跟上面类似的，有
        // pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i][j]
        private int[][] pre;
        private int m;
        private int n;

        public NumMatrix(int[][] matrix) {
            this.m = matrix.length;
            if (this.m == 0) return;
            this.n = matrix[0].length;
            this.pre = new int[this.m + 1][this.n + 1];
            // 为了后续编码简单，不用再特别处理0的情况
            for (int i = 0; i < this.n + 1; i++) {
                this.pre[0][i] = 0;
            }
            for (int i = 0; i < this.m + 1; i++) {
                this.pre[i][0] = 0;
            }
            for (int i = 1; i < this.m + 1; i++) {
                for (int j = 1; j < this.n + 1; j++) {
                    this.pre[i][j] = this.pre[i - 1][j] + this.pre[i][j - 1] - this.pre[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (this.m == 0) return 0;
            if (row1 < 0 || row1 >= this.m || row2 < 0 || row2 >= this.m
                    || col1 < 0 || col1 >= this.n || col2 < 0 || col2 >= this.n)
                return 0;
            row1++;
            col1++;
            row2++;
            col2++;
            return this.pre[row2][col2] - this.pre[row1 - 1][col2] - this.pre[row2][col1 - 1] + this.pre[row1 - 1][col1 - 1];
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}