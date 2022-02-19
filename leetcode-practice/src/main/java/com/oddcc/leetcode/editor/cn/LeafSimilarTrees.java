// 872

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        Solution solution = new LeafSimilarTrees().new Solution();
        System.out.println(solution.leafSimilar(
                TreeNode.constructFromArr(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
                TreeNode.constructFromArr(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)));
        System.out.println(solution.leafSimilar(
                TreeNode.constructFromArr(1),
                TreeNode.constructFromArr(1)));
        System.out.println(solution.leafSimilar(
                TreeNode.constructFromArr(1),
                TreeNode.constructFromArr(2)));
        System.out.println(solution.leafSimilar(
                TreeNode.constructFromArr(1, 2),
                TreeNode.constructFromArr(2, 2)));
        System.out.println(solution.leafSimilar(
                TreeNode.constructFromArr(1, 2, 3),
                TreeNode.constructFromArr(1, 3, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,中序遍历,保存叶子节点,然后对比
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> l1 = getLeaf(root1);
            List<Integer> l2 = getLeaf(root2);
            if (l1.size() != l2.size()) return false;
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).equals(l2.get(i))) return false;
            }
            return true;
        }

        private List<Integer> getLeaf(TreeNode root) {
            List<Integer> l = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.left == null && root.right == null) l.add(root.val);
                root = root.right;
            }
            System.out.println(l);
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}