package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            if (len == 0) return ans;
            Arrays.sort(nums);
            List<Integer> path = new ArrayList<>();
            boolean[] used = new boolean[len];
            Set<List<Integer>> cache = new HashSet<>();
            // 这里指定3，是因为题目是three sum
            dfs(nums, 3, 0, path, used, cache, ans);
            return ans;
        }

        private void dfs(int[] nums, int len, int target, List<Integer> path, boolean[] used, Set<List<Integer>> cache, List<List<Integer>> ans) {
            if (path.size() == len && target == path.stream().reduce(0, Integer::sum)) {
                path = new ArrayList<>(path);
                path.sort(Comparator.comparingInt(a -> a));
                if (!cache.contains(path)) {
                    cache.add(path);
                    ans.add(path);
                }
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, target - nums[i], path, used, cache, ans);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}