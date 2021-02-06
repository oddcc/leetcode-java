// 1423

package com.oddcc.leetcode.editor.cn;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        // System.out.println(solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        // solution.max = 0;
        // System.out.println(solution.maxScore(new int[]{2, 2, 2}, 2));
        // solution.max = 0;
        // System.out.println(solution.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        // solution.max = 0;
        // System.out.println(solution.maxScore(new int[]{1, 1000, 1}, 1));
        // solution.max = 0;
        // System.out.println(solution.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
        solution.max = 0;
        System.out.println(solution.maxScore(new int[]{99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29}, 27));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int max = 0;

        // 思路1，回溯法，利用数组记录选择PATH，并更新最终结果
        public int maxScore(int[] cardPoints, int k) {
            int len = cardPoints.length;
            search(cardPoints, k, 1, 1, len - 1, cardPoints[0]);
            search(cardPoints, k, 1, 0, len - 2, cardPoints[len - 1]);
            return max;
        }

        // start和end是取值范围，下一步可以取其中之一
        private void search(int[] cardPoints, int k, int pathLen, int start, int end, int sum) {
            if (pathLen >= k || start > end) {
                max = Math.max(sum, max);
                return;
            }
            search(cardPoints, k, pathLen + 1, start + 1, end, sum + cardPoints[start]);
            search(cardPoints, k, pathLen + 1, start, end - 1, sum + cardPoints[end]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}