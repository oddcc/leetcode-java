// 703

package com.oddcc.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
        new KthLargestElementInAStream().test();
    }

    private void test() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;
        private int k;

        // size不到k就入最小堆，否则就跟最小堆堆顶元素比较，如果大于堆顶元素，则入最小堆，并把多于k的元素出堆
        // 并入最大堆，如果小于堆顶元素，则入最大堆
        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
            maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
            this.k = k;
            for (int i: nums) {
                this.add(i);
            }
        }

        public int add(int val) {
            if (minHeap.size() < this.k) {
                minHeap.add(val);
            }
            else {
                int m = minHeap.peek();
                if (val > m) {
                    minHeap.add(val);
                    maxHeap.add(minHeap.poll());
                }
                else {
                    maxHeap.add(val);
                }
            }

            return minHeap.peek();
        }
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}