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
        // 思路1，一次遍历
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            if (nums.length == 0) return ans;
            if (nums.length == 1) {
                ans.add(String.valueOf(nums[0]));
                return ans;
            }
            int start = 0;
            int end = 1;
            while (end < nums.length) {
                if (nums[end] != nums[end - 1] + 1) {
                    if (start == end - 1) {
                        ans.add(String.valueOf(nums[start]));
                    }
                    else {
                        ans.add(nums[start] + "->" + nums[end - 1]);
                    }
                    start = end;
                }
                end++;
            }
            if (nums[end - 1] != nums[end - 2] + 1) {
                ans.add(String.valueOf(nums[start]));
            }
            else {
                ans.add(nums[start] + "->" + nums[end - 1]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}