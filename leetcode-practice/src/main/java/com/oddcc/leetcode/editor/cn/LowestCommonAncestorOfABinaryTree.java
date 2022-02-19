// 236

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.*;

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
        // 思路2，参考思路1，反正都有O(N)的空间复杂度，可以考虑使用dfs遍历，用哈希表存储节点的父节点，这样就很容易能得到根到节点的路径
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Map<Integer, TreeNode> parentCache = new HashMap<>();
            dfs(root, null, parentCache);
            List<TreeNode> pathP = findPath(p, parentCache);
            List<TreeNode> pathQ = findPath(q, parentCache);
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

        private List<TreeNode> findPath(TreeNode p, Map<Integer, TreeNode> parentCache) {
            List<TreeNode> path = new ArrayList<>();
            while (p != null) {
                path.add(p);
                p = parentCache.get(p.val);
            }
            Collections.reverse(path);
            return path;
        }

        private void dfs(TreeNode root, TreeNode parent, Map<Integer, TreeNode> parentCache) {
            if (parent != null) parentCache.put(root.val, parent);
            if (root.left != null) dfs(root.left, root, parentCache);
            if (root.right != null) dfs(root.right, root, parentCache);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}