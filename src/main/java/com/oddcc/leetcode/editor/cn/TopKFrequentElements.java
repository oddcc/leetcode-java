// 347

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 要求时间复杂度至少是O(NlogN)
        // 思路1，利用哈希表存元素数量，利用容量为k的最大堆来取第k大的数，遍历的同时，不停的入堆，最后再从堆中弹出第k个元素，就是答案
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
            for (int i : nums) {
                if (countMap.containsKey(i)) {
                    countMap.put(i, countMap.get(i) + 1);
                }
                else {
                    countMap.put(i, 1);
                }
            }

            for (int i : countMap.keySet()) {
                System.out.println("add " + i);
                maxHeap.add(i);
                if (maxHeap.size() > k) {
                    System.out.println("remove " + maxHeap.remove());
                }
            }

            int[] ans = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                int n = maxHeap.remove();
                System.out.println("retrieve " + n);
                ans[i] = n;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}