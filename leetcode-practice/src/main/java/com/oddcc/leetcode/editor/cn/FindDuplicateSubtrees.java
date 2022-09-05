// 652

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
        System.out.println(solution.findDuplicateSubtrees(TreeNode.constructFromArr(1, 2, 3, 4, null, 2, 4, null, null, 4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> ans = new ArrayList<>();
            Map<String, Integer> shown = new HashMap<>();
            dfs(root, shown, ans);
            return ans;
        }

        private String dfs(TreeNode root, Map<String, Integer> shown, List<TreeNode> ans) {
            if (root == null) {
                return "null";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(root.val)
                    .append(",")
                    .append(dfs(root.left, shown, ans))
                    .append(",")
                    .append(dfs(root.right, shown, ans));
            String treeStr = sb.toString();
            shown.put(treeStr, shown.getOrDefault(treeStr, 0) + 1);
            if (shown.get(treeStr) == 2) {
                ans.add(root);
            }
            return treeStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}