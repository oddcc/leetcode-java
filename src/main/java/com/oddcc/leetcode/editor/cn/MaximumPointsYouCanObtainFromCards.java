// 1423

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        System.out.println(solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        solution.max = 0;
        System.out.println(solution.maxScore(new int[]{2, 2, 2}, 2));
        solution.max = 0;
        System.out.println(solution.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        solution.max = 0;
        System.out.println(solution.maxScore(new int[]{1, 1000, 1}, 1));
        solution.max = 0;
        System.out.println(solution.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int max = 0;

        // 思路1，回溯法，利用数组记录选择PATH，并更新最终结果
        public int maxScore(int[] cardPoints, int k) {
            List<Integer> path = new ArrayList<>();
            int len = cardPoints.length;
            path.add(0);
            search(cardPoints, k, path, 1, len - 1, cardPoints[0]);
            path.remove(path.size() - 1);
            path.add(cardPoints[len - 1]);
            search(cardPoints, k, path, 0, len - 2, cardPoints[len - 1]);
            path.remove(path.size() - 1);
            return max;
        }

        // start和end是取值范围，下一步可以取其中之一
        private void search(int[] cardPoints, int k, List<Integer> path, int start, int end, int sum) {
            if (path.size() >= k || start > end) {
                max = Math.max(sum, max);
                return;
            }
            path.add(start);
            search(cardPoints, k, path, start + 1, end, sum + cardPoints[start]);
            path.remove(path.size() - 1);
            path.add(end);
            search(cardPoints, k, path, start, end - 1, sum + cardPoints[end]);
            path.remove(path.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}