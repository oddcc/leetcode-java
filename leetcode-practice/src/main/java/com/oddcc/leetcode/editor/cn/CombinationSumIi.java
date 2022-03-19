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
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void dfs(int[] candidates, int remain, int start, ArrayList<Integer> path, List<List<Integer>> ans) {
            if (remain == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            if (start >= candidates.length) return;
            for (int i = start; i < candidates.length; i++) {
                int num = candidates[i];
                if (num > remain) {
                    return;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(num);
                dfs(candidates, remain - num, i + 1, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}