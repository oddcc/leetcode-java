package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            if (len == 0) {
                return ans;
            }
            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();
            dfs(nums, len, path, used, ans);
            return ans;
        }

        /**
         * 找到nums中所有符合条件的结果，即遍历结果集（是一颗完全二叉树 full binary tree）的所有叶子节点
         * @param nums 原数据集
         * @param len 要求的结果长度，用于判断是否达到基准条件
         * @param path 当前结果
         * @param used 记录元素是否使用过
         * @param ans 最终结果集，当达到基准条件时，应该把符合条件的结果加入结果集
         */
        private void dfs(int[] nums, int len, List<Integer> path, boolean[] used, List<List<Integer>> ans) {
            // 重点理解，结果都在树的叶子节点上，这里return时，dfs的调用栈应该是len+1层，实际的遍历逻辑执行了len次
            if (len == path.size()) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < len; i++) {
                // 当一个元素是用过的，直接跳过，不能再使用此元素
                if (used[i]) {
                    continue;
                }
                // 元素加入当前结果，并标记使用过
                path.add(nums[i]);
                used[i] = true;
                // 继续搜索，这里path有变化了，意味着待解决的问题规模缩小了，离基准条件更近了
                dfs(nums, len, path, used, ans);
                // 搜索完成后，把用过的元素从结果中移除，标记为「未使用」状态，这样接下来的搜索中才能使用这个元素
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}