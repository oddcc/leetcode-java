// 1482

package com.oddcc.leetcode.editor.cn;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfDaysToMakeMBouquets().new Solution();
        System.out.println(solution.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(solution.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(solution.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(solution.minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，二分查找，当m*k<n时，返回-1；当m*k>=n时，一定有答案，要求的是最小天数，而且答案在(0,max(bloomDay)]这个范围之内
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int len = bloomDay.length;
            if (len < m * k) return -1;

            int left = 0;
            int right = 0;
            for (int value : bloomDay) {
                right = Math.max(right, value);
            }
            while (left < right) {
                int mid = (right - left) / 2 + left; // 天数
                int bouquets = 0;
                int i = 0;
                int bloomCount = 0;
                while (i < len) {
                    // 小于等于mid，则说明是符合条件的
                    if (bloomDay[i] <= mid) {
                        bloomCount++;
                    }
                    // 如果大于mid，则说明不符合条件了，计算可以制作多少花束
                    else {
                        bouquets += bloomCount / k;
                        bloomCount = 0;
                    }
                    i++;
                    if (i == len) {
                        bouquets += bloomCount / k;
                        break;
                    }
                }
                if (bouquets >= m) right = mid;
                else left = mid + 1;
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}