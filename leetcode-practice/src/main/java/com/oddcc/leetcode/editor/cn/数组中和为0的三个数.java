// 剑指 Offer II 007

package com.oddcc.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 数组中和为0的三个数 {
    public static void main(String[] args) {
        Solution solution = new 数组中和为0的三个数().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> ans = new HashSet<>();
            Arrays.sort(nums);
            Map<Integer, List<Integer>> numsMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (numsMap.containsKey(nums[i])) {
                    numsMap.get(nums[i]).add(i);
                } else {
                    numsMap.put(nums[i], new ArrayList<>());
                    numsMap.get(nums[i]).add(i);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                int v = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int n = nums[j];
                    if (j > i + 1 && n == nums[j - 1]) {
                        continue;
                    }
                    int want = -v - n;
                    if (numsMap.containsKey(want)) {
                        for (int wantIndex : numsMap.get(want)) {
                            if (wantIndex > j) {
                                ans.add(Stream.of(v, n, want).sorted().collect(Collectors.toList()));
                            }
                        }
                    }
                }
            }

            List<List<Integer>> res = new ArrayList<>();
            for (List<Integer> a : ans) {
                res.add(new ArrayList<>(a));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}