// 78

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] n1 = new int[]{1, 2, 3};
        System.out.println(solution.subsets(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目要求输出所有结果，极有可能要遍历，所以考虑回溯法
        // 把图画出来可以看到，集合的全部结果都在叶子节点，一共会有2^n个结果。理论上说，每个元素有选\不选两种可能，一共n个元素，所以是2^n个结果
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(nums, 0, path, ans);
            return ans;
        }

        private void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> ans) {
            // 当选过i次之后返回
            if (i > nums.length - 1) {
                ans.add(new ArrayList<>(path));
                return;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, path, ans); // 选择i的结果
            path.remove(path.size() - 1);
            dfs(nums, i + 1, path, ans); // 不选择i的结果
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}