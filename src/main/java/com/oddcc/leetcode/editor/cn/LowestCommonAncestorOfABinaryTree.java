// 236

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode t1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        // TreeNode t1 = new TreeNode(3);
        System.out.println(solution.lowestCommonAncestor(t1, new TreeNode(5), new TreeNode(4)).val);
        System.out.println(solution.lowestCommonAncestor(t1, new TreeNode(5), new TreeNode(1)).val);
        System.out.println(solution.lowestCommonAncestor(t1, new TreeNode(3), new TreeNode(3)).val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，如果能得到两个点到根节点的路径，然后从根节点开始对比两个路径，最后一个相同的节点就是答案
        // TreeNode没有指向父节点的指针，只能通过root进行遍历，寻找p和q，可以采用回溯算法
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pathP = findPath(root, p, new ArrayList<>(Collections.singletonList(root)));
            List<TreeNode> pathQ = findPath(root, q, new ArrayList<>(Collections.singletonList(root)));
            assert pathP != null;
            assert pathQ != null;
            int pP = 0;
            int pQ = 0;
            TreeNode ans = null;
            TreeNode pre = null;
            while (true) {
                if (pP >= pathP.size() || pQ >= pathQ.size()) {
                    ans = pre;
                    break;
                }
                TreeNode nP = pathP.get(pP++);
                TreeNode nQ = pathQ.get(pQ++);
                if (nP.val == nQ.val) {
                    pre = nP;
                    continue;
                }
                ans = pre;
                break;
            }
            return ans;
        }

        private List<TreeNode> findPath(TreeNode root, TreeNode p, List<TreeNode> path) {
            if (root.val == p.val) return new ArrayList<>(path);
            if (root.left == null && root.right == null) return null;
            List<TreeNode> ans = null;
            if (root.left != null) {
                path.add(root.left);
                ans = findPath(root.left, p, path);
                if (ans != null) return ans;
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                path.add(root.right);
                ans = findPath(root.right, p, path);
                if (ans != null) return ans;
                path.remove(path.size() - 1);
            }
            return ans;
        }

        private void dfs(TreeNode root, TreeNode p, List<TreeNode> path) {

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}