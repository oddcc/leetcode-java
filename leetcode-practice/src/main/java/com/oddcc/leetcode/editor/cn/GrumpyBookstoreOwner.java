// 1052

package com.oddcc.leetcode.editor.cn;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new GrumpyBookstoreOwner().new Solution();
        System.out.println(solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，视为有一个长度为X的滑动窗口，跟窗口相连且grumpy[i] == 1的情况，可以扩展窗口的边界
        // 求所有可能性中，和的最大值是多少
        // 滑动窗口内的所有customers[i]都要计算，滑动窗口外的customers[i]要根据grumpy[i]的值来计算
        // 思路2，前缀和数组，准备两个前缀和数组
        // 分别是customers的前缀和数组total，利用total计算子数组的和时，表示对应的customers都被满足了
        // 结合了customers和grumpy的数组grumpyTotal，利用grumpyTotal计算子数组的和时，表示默认情况下customers被满足的情况
        // 有一个长度为X的滑动窗口，起始位置为left，结束位置为right
        // 在滑动窗口内部，满足的顾客数使用total来计算，在滑动窗口外部，满足的顾客数使用grumpyTotal来计算
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int len = customers.length;
            int[] totalPreSum = new int[len];
            int[] grumpyTotalPreSum = new int[len];
            for (int i = 0; i < len; i++) {
                totalPreSum[i] = (i - 1 >= 0 ? totalPreSum[i - 1] : 0) + customers[i];
                grumpyTotalPreSum[i] = (i - 1 >= 0 ? grumpyTotalPreSum[i - 1] : 0) + (grumpy[i] == 1 ? 0 : customers[i]);
            }
            int ans = 0;
            for (int right = X - 1; right < len; right++) {
                int left = right - X + 1;
                // 每次计算3部分，[0, left - 1]  [left, right]  [right + 1, len - 1]
                ans = Math.max(
                        ans,
                        culPreSum(grumpyTotalPreSum, 0, left - 1)
                                + culPreSum(totalPreSum, left, right)
                                + culPreSum(grumpyTotalPreSum, right + 1, len - 1)
                );
            }
            return ans;
        }

        // 在前缀和数组中计算原数组[left,right]范围内的元素之和，如果区间不合法要求的结果为0
        private int culPreSum(int[] preSumArr, int left, int right) {
            if (left > right) return 0;
            if (left - 1 >= 0) return preSumArr[right] - preSumArr[left - 1];
            return preSumArr[right];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}