// 1738

package com.oddcc.leetcode.editor.cn;

import java.util.PriorityQueue;

public class FindKthLargestXorCoordinateValue {
    public static void main(String[] args) {
        Solution solution = new FindKthLargestXorCoordinateValue().new Solution();
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 第k大的问题,考虑利用堆
    // 思路1,问题的关键在于如何快速求出矩阵的异或值,可以利用动态规划来做
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            // dp[i][j]表示左上(0,0)，右下(i,j)的矩阵的异或值
            // 这里使用m+1和n+1，是为了方便处理边界值，但在计算中要注意对应位置
            int[][] dp = new int[m + 1][n + 1];
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int xor = matrix[i - 1][j - 1] ^ dp[i - 1][j - 1] ^ dp[i][j - 1] ^ dp[i - 1][j];
                    dp[i][j] = xor;
                    int top = minHeap.size() > 0 ? minHeap.peek() : 0;
                    // 如果堆中还不到k个数,则入堆
                    if (minHeap.size() < k) {
                        minHeap.add(xor);
                    }
                    // 如果堆中已有k个数,则看当前xor是否大于堆顶,是的话才入堆,否则不参与结果的比较
                    else {
                        if (xor > top) {
                            if (minHeap.size() >= k) minHeap.poll();
                            minHeap.add(xor);
                        }
                    }
                }
            }
            return minHeap.remove();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}