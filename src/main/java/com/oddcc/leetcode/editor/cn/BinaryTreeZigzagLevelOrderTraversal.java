// 103

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode n1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.zigzagLevelOrder(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，z字形实际上还是层次遍历，只是多加一个flag，然后根据flag的值，在加入结果集之前把数组reverse
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;
            ans.add(Collections.singletonList(root.val));
            Queue<TreeNode> preLayer = new LinkedList<>();
            preLayer.add(root);
            boolean reverse = true;
            while (!preLayer.isEmpty()) {
                int len = preLayer.size();
                List<Integer> layer = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode n = preLayer.remove();
                    if (n.left != null) {
                        layer.add(n.left.val);
                        preLayer.add(n.left);
                    }
                    if (n.right != null) {
                        layer.add(n.right.val);
                        preLayer.add(n.right);
                    }
                }
                if (reverse) {
                    Collections.reverse(layer);
                }
                reverse = !reverse;
                if (!layer.isEmpty()) ans.add(layer);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}