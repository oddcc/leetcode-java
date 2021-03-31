// 90

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(solution.subsetsWithDup(new int[]{0}));
        System.out.println(solution.subsetsWithDup(new int[]{}));
        System.out.println(solution.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，回溯法遍历所有可能的结果，每个位置都有选或不选两种，整个结果集就是一颗二叉树（Root不含信息，高为nums.length+1），所有符合条件的子集都在叶子节点，但要注意去重
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Set<List<Integer>> ansSet = new HashSet<>();
            dfs(ansSet, nums, new ArrayList<>(), 0);
            return new ArrayList<>(ansSet);
        }

        /**
         *
         * @param ans 答案集合
         * @param nums 原始数据
         * @param path 截止目前的子集（单个）
         * @param i 下一个要访问的元素
         */
        private void dfs(Set<List<Integer>> ans, int[] nums, ArrayList<Integer> path, int i) {
            if (i >= nums.length) {
                List<Integer> s = new ArrayList<>(path);
                s.sort(Integer::compare);
                ans.add(s);
                return;
            }
            path.add(nums[i]);
            dfs(ans, nums, path, i + 1);
            path.remove(path.size() - 1);
            dfs(ans, nums, path, i + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}