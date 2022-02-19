// 951

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class FlipEquivalentBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new FlipEquivalentBinaryTrees().new Solution();
        System.out.println(solution.flipEquiv(
                TreeNode.constructFromArr(1, 2, 3, 4, 5, 6, null, null, null, 7, 8),
                TreeNode.constructFromArr(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7)
        ));
        System.out.println(solution.flipEquiv(
                TreeNode.constructFromArr(),
                TreeNode.constructFromArr()
        ));
        System.out.println(solution.flipEquiv(
                TreeNode.constructFromArr(),
                TreeNode.constructFromArr(1)
        ));
        System.out.println(solution.flipEquiv(
                TreeNode.constructFromArr(0, null, 1),
                TreeNode.constructFromArr(0, 1)
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,递归,方法返回root1和root2是否是相等的
    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            // 一个是null,一个不是null,则一定不相等
            if (root1 == null || root2 == null) {
                return false;
            }
            // 根节点都不同,肯定不相等,因为无论如何反转,根节点是不会变的
            if (root1.val != root2.val) {
                return false;
            }
            // 两种情况,如果本次进行了反转,则root1.left和root2.right应该是相等的
            // 如果每次没有进行反转,则root1.left和root2.left应该是相等的
            return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
                    || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}