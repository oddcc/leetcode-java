// 1893

package com.oddcc.leetcode.editor.cn;

public class CheckIfAllTheIntegersInARangeAreCovered {
    public static void main(String[] args) {
        Solution solution = new CheckIfAllTheIntegersInARangeAreCovered().new Solution();
        System.out.println(solution.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
        System.out.println(solution.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，暴力枚举
    class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            for (int i = left; i <= right; i++) {
                boolean inRange = false;
                for (int[] range : ranges) {
                    inRange = range[0] <= i && range[1] >= i;
                    if (inRange) break;
                }
                if (!inRange) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}