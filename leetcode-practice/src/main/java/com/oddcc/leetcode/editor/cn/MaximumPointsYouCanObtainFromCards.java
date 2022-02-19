// 1423

package com.oddcc.leetcode.editor.cn;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        System.out.println(solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(solution.maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(solution.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(solution.maxScore(new int[]{1, 1000, 1}, 1));
        System.out.println(solution.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
        System.out.println(solution.maxScore(new int[]{99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29}, 27));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，深度搜索回溯法，利用数组记录选择PATH，并更新最终结果
        // 思路2，求最大值的问题，转化为求最小值的问题，因为每次从两端取值，最终剩下的是数组中的一个连续的子数组，且子数组的长度是已知的
        // 可以利用滑动窗口求子数组的最小和，减掉总和，就是最大值
        public int maxScore(int[] cardPoints, int k) {
            int len = cardPoints.length;
            int sum = 0;
            int subSum = 0;
            int min = Integer.MAX_VALUE;
            int right = (len - k) - 1;
            while (right < len) {
                if (right == (len - k) - 1) {
                    for (int i = 0; i <= (len - k) - 1; i++) {
                        sum += cardPoints[i];
                    }
                    subSum = sum;
                    min = subSum;
                }
                else {
                    sum += cardPoints[right];
                    subSum += cardPoints[right];
                    subSum -= cardPoints[right - (len - k) + 1 - 1];
                    min = Math.min(subSum, min);
                }
                right++;
            }
            return sum - min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}