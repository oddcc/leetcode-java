// 1438

package com.oddcc.leetcode.editor.cn;

import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        Solution solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
        System.out.println(solution.longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(solution.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(solution.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，利用滑动窗口，遍历时记录子数组内的最大值和最小值（最大堆和最小堆）
        // 当absolute difference小于等于limit时，扩展右边界
        // 反之收缩左边界
        public int longestSubarray(int[] nums, int limit) {
            int ans = 0;
            int len = nums.length;
            int right = 0;
            int left = 0;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            while (right < len) {
                int n = nums[right];
                maxHeap.add(n);
                minHeap.add(n);
                if (maxHeap.peek() - minHeap.peek() > limit) {
                    ans = Math.max(ans, right - left);
                    maxHeap.remove(nums[left]);
                    minHeap.remove(nums[left]);
                    left++;
                }
                else {
                    if (right == len - 1) {
                        ans = Math.max(ans, right - left + 1);
                    }
                }
                right++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}