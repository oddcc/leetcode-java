// 215

package com.oddcc.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(solution.findKthLargest(new int[]{2, 1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，第K大的元素，第一想法是使用堆；有len个元素，第K大，全部入堆，再弹出K-1个，堆顶就是第K大
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i : nums) {
                maxHeap.add(i);
            }
            for (int i = 0; i < k - 1; i++) maxHeap.poll();
            return maxHeap.poll();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}