// 538

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        TreeNode t1 = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        System.out.println(solution.convertBST(t1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;
        // 思路1，BST的中序遍历得到的是升序结果，我们得到这个数组后，可以直接求出每个节点处理后的值
        // 有了之后的值，可以通过再一次中序遍历，把值赋值回去，就完成了
        public TreeNode convertBST(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfs(root, result);
            System.out.println(result);
            int size = result.size();
            for (int i = size - 1; i >= 0; i--) {
                if (i < size - 1) result.set(i, result.get(i + 1) + result.get(i));
            }
            System.out.println(result);
            dfs2(root, result);
            return root;
        }

        private void dfs2(TreeNode root, List<Integer> result) {
            if (root == null) return;
            dfs2(root.left, result);
            root.val = result.get(count++);
            dfs2(root.right, result);
        }

        private void dfs(TreeNode root, List<Integer> result) {
            if (root == null) return;
            dfs(root.left, result);
            result.add(root.val);
            dfs(root.right, result);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}