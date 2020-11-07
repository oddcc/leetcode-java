package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
        //        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{-2, 2}, {1, 3}}, 1)));
        //        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
        //        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{6,10},{-3,3},{-2,5},{0,2}}, 3)));
                System.out.println(Arrays.toString(solution.kClosest(new int[][]{{68, 97}, {34, -84}, {60, 100}, {2, 31}, {-27, -38}, {-73, -74}, {-55, -39}, {62, 91}, {62, 92}, {-57, -67}}, 5)));
//        System.out.println(Arrays.toString(solution.kClosest(new int[][]{{9, 9}, {8, 8}, {7, 7}, {6, 6}, {5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1}, {-5, -7}}, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接排序，排序后取第K - 1个即可，时间复杂度和空间复杂度取决于采用的排序算法
        // 思路2，N个point，直接构建一个最大堆，然后不停的删除最大元素，删除K-1个元素，处于堆顶的就是第K大的元素
        // 如何构建堆，https://www.tutorialspoint.com/data_structures_algorithms/heap_data_structure.htm
        // 简单的说，如果是一个最大堆，则每次在堆底增加元素，然后进行上浮，最后形成的就是最大堆（大于父节点的上浮）；最小堆同理
        // 如何用数组表示堆：https://www.geeksforgeeks.org/array-representation-of-binary-heap/
        public int[][] kClosest(int[][] points, int K) {
            int[][] maxPointHeap = generateMaxHeap(points);
            for (int i = 0; i < points.length - K; i++) {
                deleteMax(maxPointHeap);
            }
            int[][] ans = Arrays.copyOf(maxPointHeap, K);
            return ans;
        }

        private void deleteMax(int[][] maxHeap) {
            int tail = maxHeap.length - 1;
            while (maxHeap[tail] == null) {
                tail--;
            }
            // 删除思路是，top跟tail交换，然后tail下潜
            // 下潜的思路是，跟大的子节点交换，直到下沉到底或大于两个子节点
            maxHeap[0] = maxHeap[tail];
            maxHeap[tail] = null;
            int i = 0;
            while (i < tail) {
                int[] left = (2 * i) + 1 < tail ? maxHeap[(2 * i) + 1] : null;
                int[] right = (2 * i) + 2 < tail ? maxHeap[(2 * i) + 2] : null;
                if (compare(maxHeap[i], left) >= 0 && compare(maxHeap[i], right) >= 0) break;
                if (compare(left, right) > 0) {
                    int[] tmp = maxHeap[(2 * i) + 1];
                    maxHeap[(2 * i) + 1] = maxHeap[i];
                    maxHeap[i] = tmp;
                    i = (2 * i) + 1;
                }
                else {
                    int[] tmp = maxHeap[(2 * i) + 2];
                    maxHeap[(2 * i) + 2] = maxHeap[i];
                    maxHeap[i] = tmp;
                    i = (2 * i) + 2;
                }
            }
        }

        private int[][] generateMaxHeap(int[][] points) {
            int[][] heap = new int[points.length][2];
            heap[0] = points[0];
            for (int i = 1; i < points.length; i++) {
                heap[i] = points[i];
                // i进行上浮
                int t = i;
                while (t > 0) {
                    int[] parent = heap[(t - 1) / 2];
                    int[] current = heap[t];
                    if (compare(parent, current) < 0) {
                        heap[(t - 1) / 2] = current;
                        heap[t] = parent;
                    }
                    t--;
                }
            }
            return heap;
        }

        private int compare(int[] x, int[] y) {
            if (x == null) return -1;
            if (y == null) return 1;
            return (x[0] * x[0] + x[1] * x[1]) - (y[0] * y[0] + y[1] * y[1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}