// 剑指 Offer 07

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        TreeNode n = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        /**
         * 根据前序遍历和中序遍历的结果构造二叉树
         * @param preorder
         * @param preL 前序遍历左边界
         * @param preR 前序遍历右边界
         * @param inorder
         * @param inL 中序遍历左边界
         * @param inR 中序遍历又边界
         * @return 生成的树的root
         */
        private TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
            if (preL > preR) return null;
            // 前序遍历的第一个数字是根节点
            TreeNode root = new TreeNode(preorder[preL]);
            int rootIndex = search(inorder, inL, inR, root.val);
            // 求左子树有几个节点
            int leftCount = rootIndex - inL;
            root.left = buildTree(preorder, preL + 1, preL + 1 + leftCount - 1, inorder, inL, rootIndex - 1);
            root.right = buildTree(preorder, preL + 1 + leftCount - 1 + 1, preR, inorder, rootIndex + 1, inR);
            return root;
        }

        private int search(int[] arr, int left, int right, int target) {
            for (int i = left; i <= right; i++) {
                if (arr[i] == target) return i;
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}