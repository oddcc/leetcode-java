// 1403

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumSubsequenceInNonIncreasingOrder {
    public static void main(String[] args) {
        Solution solution = new MinimumSubsequenceInNonIncreasingOrder().new Solution();
        System.out.println(solution.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(solution.minSubsequence(new int[]{4, 4, 7, 6, 7}));
        System.out.println(solution.minSubsequence(new int[]{6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            List<Integer> sorted = Arrays.stream(nums).boxed()
                    .sorted((i1, i2) -> i2 - i1)
                    .collect(Collectors.toList());
            int sum = sorted.stream().mapToInt(Integer::intValue).sum();
            List<Integer> ans = new ArrayList<>();
            int total = 0;
            for (int i : sorted) {
                ans.add(i);
                total += i;
                int remain = sum - total;
                if (total > remain) {
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}