package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{-2, 2}, {1, 3}}, 1)));
        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{6, 10}, {-3, 3}, {-2, 5}, {0, 2}}, 3)));
        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{68, 97}, {34, -84}, {60, 100}, {2, 31}, {-27, -38}, {-73, -74}, {-55, -39}, {62, 91}, {62, 92}, {-57, -67}}, 5)));
        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{9, 9}, {8, 8}, {7, 7}, {6, 6}, {5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1}, {-5, -7}}, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接排序，排序后取第K - 1个即可，时间复杂度和空间复杂度取决于采用的排序算法
        // 思路2，N个point，直接构建一个最大堆，然后不停的删除最大元素，删除K-1个元素，处于堆顶的就是第K大的元素
        // 如何构建堆，https://www.tutorialspoint.com/data_structures_algorithms/heap_data_structure.htm
        // 简单的说，如果是一个最大堆，则每次在堆底增加元素，然后进行上浮，最后形成的就是最大堆（大于父节点的上浮）；最小堆同理
        // 如何用数组表示堆：https://www.geeksforgeeks.org/array-representation-of-binary-heap/
        // 思路2超时，问题在于，对很大的输入来说，必须要构造完整的堆，然后再开始弹出
        // 思路3，构造包含K个元素的堆，用K个元素构造堆后，新的元素如果小于堆顶元素（至今最大），就加入堆，并弹出堆顶元素，直到结束
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] x, int[] y) {
                    if (x == null) return -1;
                    if (y == null) return 1;
                    return (y[0] * y[0] + y[1] * y[1]) - (x[0] * x[0] + x[1] * x[1]);
                }
            });
            for (int i = 0; i < points.length; i++) {
                int[] p = points[i];
                if (i < K) {
                    maxHeap.add(p);
                }
                else {
                    // p小于堆顶元素，弹出堆顶元素并让p入堆
                    int[] p2 = maxHeap.peek();
                    if (compare(p, p2) < 0) {
                        maxHeap.poll();
                        maxHeap.add(p);
                    }
                }
            }
            int[][] ans = new int[K][2];
            for (int i = 0; i < K; i++) {
                ans[i] = maxHeap.poll();
            }
            return ans;
        }

        private int compare(int[] x, int[] y) {
            if (x == null) return -1;
            if (y == null) return 1;
            return (x[0] * x[0] + x[1] * x[1]) - (y[0] * y[0] + y[1] * y[1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}