// 40

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // #1 brute force, back track, will cause timeout
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Set<List<Integer>> used = new HashSet<>();
            Arrays.sort(candidates);
            dfs(ans, candidates, used, 0, 0, new ArrayList<>(), target);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int[] candidates, Set<List<Integer>> used, int i, int total, List<Integer> current, int target) {
            if (total > target) return;
            if (total == target) {
                current.sort(Integer::compareTo);
                if (used.contains(current)) return;
                ans.add(current);
                used.add(new ArrayList<>(current));
                return;
            }
            if (i >= candidates.length) return;

            int num = candidates[i];
            total += num;
            List<Integer> arr = new ArrayList<>(current);
            arr.add(num);
            dfs(ans, candidates, used, i + 1, total, arr, target);

            total -= num;
            arr = new ArrayList<>(current);
            dfs(ans, candidates, used, i + 1, total, arr, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}