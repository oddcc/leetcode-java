// 94
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(solution.inorderTraversal(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 二叉树的中序遍历，要求不用递归完成；可以用栈来写
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                // 循环把root及其左节点入栈，当root为null时，栈顶是当前最后一个左节点
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 出栈的节点是当前最后一个左节点，因为是中序遍历，所以在这里保存结果
                // 接下来访问右子树
                TreeNode n = stack.pop();
                ans.add(n.val);
                root = n.right;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}