// 235

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
        TreeNode n1 = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(solution.lowestCommonAncestor(n1, new TreeNode(2), new TreeNode(8)));
        System.out.println(solution.lowestCommonAncestor(n1, new TreeNode(2), new TreeNode(4)));
        TreeNode n2 = new TreeNode(2, new TreeNode(1), null);
        System.out.println(solution.lowestCommonAncestor(n2, new TreeNode(2), new TreeNode(1)));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，两个节点向上遍历
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> parentListP = getPath(root, p, new ArrayList<>());
            List<TreeNode> parentListQ = getPath(root, q, new ArrayList<>());
            TreeNode ans = parentListP.get(0);
            for (int i = 0; i < Math.min(parentListP.size(), parentListQ.size()); i++) {
                if (parentListP.get(i).val != parentListQ.get(i).val) {
                    break;
                }
                ans = parentListP.get(i);
            }
            return ans;
        }

        private List<TreeNode> getPath(TreeNode current, TreeNode target, ArrayList<TreeNode> path) {
            if (current.val == target.val) {
                path.add(target);
                // System.out.println(path);
                return new ArrayList<>(path);
            }
            if (current.left == null && current.right == null) return null;
            if (current.left != null) {
                path.add(current);
                List<TreeNode> path1 = getPath(current.left, target, path);
                if (path1 != null) return path1;
                path.remove(path.size() - 1);
            }
            if (current.right != null) {
                path.add(current);
                List<TreeNode> path2 = getPath(current.right, target, path);
                if (path2 != null) return path2;
                path.remove(path.size() - 1);
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}