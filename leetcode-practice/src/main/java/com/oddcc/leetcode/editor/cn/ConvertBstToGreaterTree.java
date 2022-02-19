// 538

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;


public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        TreeNode t1 = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        System.out.println(solution.convertBST(t1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int sum = 0;

        // 思路1，BST的中序遍历得到的是升序结果，我们得到这个数组后，可以直接求出每个节点处理后的值
        // 有了之后的值，可以通过再一次中序遍历，把值赋值回去，就完成了
        // 思路2，如果按右根左的顺序遍历，直接得到的就是降序排列
        public TreeNode convertBST(TreeNode root) {
            dfs(root);
            return root;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.right);
            root.val += sum;
            sum = root.val;
            dfs(root.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}