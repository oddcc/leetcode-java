package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode n1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.levelOrder(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 层次遍历，利用一个列表来缓存，特点是，在把上一层加入结果中时，可以顺便访问子节点
        // 这时加入缓存的所有子节点就是下一层的所有节点，当缓存列表为空时，说明层次遍历结束了
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;
            List<TreeNode> layerCache = new ArrayList<>();
            layerCache.add(root);
            while (!layerCache.isEmpty()) {
                List<TreeNode> nextLayer = new ArrayList<>();
                List<Integer> thisLayer = new ArrayList<>();
                for (TreeNode node : layerCache) {
                    if (node.left != null) nextLayer.add(node.left);
                    if (node.right != null) nextLayer.add(node.right);
                    thisLayer.add(node.val);
                }
                layerCache = nextLayer;
                ans.add(thisLayer);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}