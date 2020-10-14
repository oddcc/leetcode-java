package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(solution.combinationSum(new int[]{2}, 1));
        System.out.println(solution.combinationSum(new int[]{1}, 1));
        System.out.println(solution.combinationSum(new int[]{1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (candidates.length == 0) return ans;
            Arrays.sort(candidates);
            List<Integer> path = new ArrayList<>();
            dfs(candidates, target, path, ans);
            return ans;
        }

        private void dfs(int[] nums, int target, List<Integer> path, List<List<Integer>> ans) {
            if (!path.isEmpty() && path.stream().reduce(0, Integer::sum) == target) {
                path = new ArrayList<>(path);
                path.sort(Integer::compareTo);
                if (!ans.contains(path)) {
                    ans.add(path);
                }
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                int sum = nums[i] + path.stream().reduce(0, Integer::sum);
                if (sum > target) {
                    return;
                }
                path.add(nums[i]);
                dfs(nums, target, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}