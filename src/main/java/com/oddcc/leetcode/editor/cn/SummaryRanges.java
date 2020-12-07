// 228

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new SummaryRanges().new Solution();
        System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(solution.summaryRanges(new int[]{}));
        System.out.println(solution.summaryRanges(new int[]{0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            int start = 0;
            int end = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 > nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                    end = i;
                    ans.add(getString(nums[start], nums[end]));
                    start = i + 1;
                }
            }
            return ans;
        }

        private String getString(int start, int end) {
            if (start == end) return String.valueOf(start);
            return start + "->" + end;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}