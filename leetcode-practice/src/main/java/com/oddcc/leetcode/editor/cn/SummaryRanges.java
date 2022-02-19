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
        // 思路2，还是一次遍历，双指针，优化代码，没有那么冗余且容易理解
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            int i = 0;
            int len = nums.length;
            while (i < len) {
                int end = i;
                while (end + 1 < len && nums[end + 1] == nums[end] + 1) {
                    end++;
                }
                if (end == i) {
                    ans.add(String.valueOf(nums[end]));
                }
                else {
                    ans.add(nums[i] + "->" + nums[end]);
                }
                i = end + 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}