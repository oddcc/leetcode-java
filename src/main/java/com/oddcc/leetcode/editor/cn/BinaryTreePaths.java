// 257

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode n1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(solution.binaryTreePaths(n1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 思路1，深度优先+回溯，每次到叶子节点的时候，记录答案
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            dfs(root, path, ans);
            return ans;
        }

        private void dfs(TreeNode root, List<TreeNode> path, List<String> ans) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                ans.add(pathToString(path));
                return;
            }
            if (root.left != null) {
                path.add(root.left);
                dfs(root.left, path, ans);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                path.add(root.right);
                dfs(root.right, path, ans);
                path.remove(path.size() - 1);
            }
        }

        private String pathToString(List<TreeNode> path) {
            if (path.isEmpty()) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0).val);
            if (path.size() > 1) {
                for (int i = 1; i < path.size(); i++) {
                    sb.append("->").append(path.get(i).val);
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}