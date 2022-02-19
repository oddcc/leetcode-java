// 1011

package com.oddcc.leetcode.editor.cn;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(solution.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 答案应该在[max(weights),sum(weights)]这个范围内，如果小于max(weights)的话，那么永远都运不完，而大于sum(weights)是没有必要的
        // 我们只要把范围内的值从小到大进行判断，就可以找到答案，如何判断一个容量x是否满足在D天内运完所有货物？
        // 通过模拟运输，可以判断是否符合，如果发现到D天了，还没运完，那么就说明不符合条件
        // 思路1，在一个区间内找符合条件的值，不用遍历，考虑二分
        public int shipWithinDays(int[] weights, int D) {
            int low = Integer.MIN_VALUE;
            int sum = 0;
            // 确定答案的上下限
            for (int i : weights) {
                low = Math.max(i, low);
                sum += i;
            }
            return search(weights, D, low, sum, sum);
        }

        // 找最后一个check为true的值
        private int search(int[] weights, int d, int low, int high, int total) {
            int mid = low + (high - low) / 2;
            // 如果mid值符合条件，那么说明mid>=ans，因为我们要的是最小值，所以再尝试向左找
            if (check(weights, d, mid, total)) {
                if (mid == high) return mid;
                return search(weights, d, low, mid, total);
            }
            // 如果mid值不符合条件，那么mid<ans，答案一定得是更大的值
            else {
                return search(weights, d, mid + 1, high, total);
            }
        }

        private boolean check(int[] weights, int d, int cap, int total) {
            int i = 0;
            int sum = 0; // 总共运了多少
            // 尝试运d天
            for (int day = 0; day < d; day++) {
                int today = 0;
                while (i < weights.length) {
                    int tmp = today + weights[i];
                    // 如果装不下了，今天就不运更多了
                    if (tmp > cap) {
                        break;
                    }
                    today = tmp;
                    i++;
                }
                sum += today;
            }
            return sum >= total;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}