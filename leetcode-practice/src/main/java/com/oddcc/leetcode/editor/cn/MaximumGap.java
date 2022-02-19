// 164

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class MaximumGap {
    public static void main(String[] args) {
        Solution solution = new MaximumGap().new Solution();
        // System.out.println(solution.maximumGap(new int[]{3, 6, 9, 1}));
        // System.out.println(solution.maximumGap(new int[]{1,10000000}));
        System.out.println(solution.maximumGap(new int[]{15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，先对数组排序，然后一次遍历；这种方式遍历的复杂度是O(N)，主要的复杂度取决于采取什么排序算法
        // 思路2，题目要求线性时间空间复杂度，所以一般的排序算法是不满足的（比如快排最小是O(NlogN)的复杂度）；但有一种排序算法是O(N)的，基数排序
        public int maximumGap(int[] nums) {
            if (nums.length < 2) return 0;
            Queue[] buckets = new Queue[10];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            int max = Arrays.stream(nums).max().getAsInt();
            int maxLength = getLength(max);
            for (int i = 0; i < maxLength; i++) {
                int[] size = new int[10];
                for (int j = 0; j < buckets.length; j++) size[j] = buckets[j].size();
                if (i == 0) {
                    for (int n : nums) {
                        int b = getIntAtN(i, n);
                        buckets[b].add(n);
                    }
                }
                else {
                    for (int j = 0; j < buckets.length; j++) {
                        Queue q = buckets[j];
                        int s = size[j];
                        while (s > 0) {
                            int n = (int) q.remove();
                            int b = getIntAtN(i, n);
                            buckets[b].add(n);
                            s--;
                        }
                    }
                }
            }
            int index = 0;
            for (Queue q : buckets) {
                while (!q.isEmpty()) {
                    int n = (int) q.remove();
                    nums[index++] = n;
                }
            }
            // 计算答案
            int ans = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] > ans) {
                    ans = nums[i + 1] - nums[i];
                }
            }
            return ans;
        }

        private int getIntAtN(int i, int n) {
            return (int) ((n / Math.pow(10, i)) % 10);
        }

        private int getLength(int max) {
            int ans = 0;
            while (max != 0) {
                max = max / 10;
                ans++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}