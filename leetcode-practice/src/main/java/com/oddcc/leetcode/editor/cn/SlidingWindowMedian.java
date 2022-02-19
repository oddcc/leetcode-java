// 480

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMedian().new Solution();
        System.out.println(Arrays.toString(solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(solution.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2)));
        System.out.println(Arrays.toString(solution.medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, 1, 3, -2147483648, -100, 8, 17, 22, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 6)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 出现的数字有重复
        // 思路1，暴力法，随着滑口的滑动，维护一个长度为k的有序数组，返回数组的中位数；维护数组可以采用插入排序，粗略估计时间复杂度可能达到O(n^3)
        // 思路2，如果维护的是个堆，则维护成本会大大下降，是否有办法取得一个堆的中位数？
        // 一个堆的中位数不好弄，但利用两个堆，可以方便的求出中位数
        // 维护一个最大堆maxHead，一个最小堆minHeap，我们要求这两个堆满足size之差不能超过1，top of maxHead <= top of minHeap
        // 当size(maxHeap) + size(minHeap)是奇数时，中位数在size较大的那个堆的堆顶
        // 当是偶数时，中位数是两个堆的堆顶元素之和/2
        public double[] medianSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            double[] ans = new double[len - (k - 1)];
            int right = k - 1;
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 这里用long是为了防溢出，下面同理
            int i = 0;
            while (right < len) {
                int left = right - (k - 1);
                ans[i++] = getMedian(nums, left, right, minHeap, maxHeap);
                right++;
            }
            return ans;
        }

        private double getMedian(int[] nums, int left, int right, PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap) {
            // 如果right - left + 1 > size(minHeap) + size(maxHeap)，说明是第一次运行，要初始化堆
            if (right - left + 1 > minHeap.size() + maxHeap.size()) {
                for (int i = left; i <= right; i++) {
                    long in = nums[i];
                    // 通过对比当前的中位数来决定新的数要放入哪个堆
                    double m = getCurrentMedian(minHeap, maxHeap);
                    if (in - m > 0.00001) {
                        minHeap.add(in);
                    }
                    else {
                        maxHeap.add(in);
                    }
                    // 平衡两个堆内的元素数量
                    while (minHeap.size() - maxHeap.size() >= 2) {
                        maxHeap.add(minHeap.poll());
                    }
                    while (maxHeap.size() - minHeap.size() >= 2) {
                        minHeap.add(maxHeap.poll());
                    }
                }
            }
            // 如果不是第一次运行，则要从对应堆中删除移出窗口的元素，加入移入窗口的元素，然后根据k的奇偶来取中位数
            else {
                double m = getCurrentMedian(minHeap, maxHeap);
                long in = nums[right];
                long out = nums[left - 1];
                if (in - m > 0.00001) {
                    minHeap.add(in);
                }
                else {
                    maxHeap.add(in);
                }
                if (!maxHeap.remove(out)) minHeap.remove(out);
                while (minHeap.size() - maxHeap.size() >= 2) {
                    maxHeap.add(minHeap.poll());
                }
                while (maxHeap.size() - minHeap.size() >= 2) {
                    minHeap.add(maxHeap.poll());
                }
            }
            return getCurrentMedian(minHeap, maxHeap);
        }

        private double getCurrentMedian(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap) {
            int size = minHeap.size() + maxHeap.size();
            if (size % 2 == 0) {
                long fromMin = minHeap.peek() == null ? 0 : minHeap.peek();
                long fromMax = maxHeap.peek() == null ? 0 : maxHeap.peek();
                return (Math.max(fromMax, fromMin) - Math.min(fromMax, fromMin)) / 2.0 + Math.min(fromMax, fromMin);
            }
            else {
                return minHeap.size() > maxHeap.size() ? minHeap.peek() : (maxHeap.peek() == null ? 0 : maxHeap.peek());
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}