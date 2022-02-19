// 993

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTree().new Solution();
        System.out.println(solution.isCousins(TreeNode.constructFromArr(1, 2, 3, 4), 4, 3));
        System.out.println(solution.isCousins(TreeNode.constructFromArr(1, 2, 3, null, 4, null, 5), 5, 4));
        System.out.println(solution.isCousins(TreeNode.constructFromArr(1, 2, 3, null, 4), 2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,遍历树,并记录每个节点的depth,并对比
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Map<Integer, Integer> depthMap = new HashMap<>();
            Map<Integer, TreeNode> parentMap = new HashMap<>();
            return dfs(root, x, y, depthMap, parentMap, 0);
        }

        private boolean dfs(TreeNode root, int x, int y, Map<Integer, Integer> depthMap, Map<Integer, TreeNode> parentMap, int depth) {
            if (depthMap.containsKey(x) && depthMap.containsKey(y) && parentMap.containsKey(x) && parentMap.containsKey(y)) {
                return depthMap.get(x).equals(depthMap.get(y)) && !parentMap.get(x).equals(parentMap.get(y));
            }
            if (root.left == null && root.right == null) {
                return false;
            }
            boolean l = false;
            if (root.left != null) {
                depthMap.put(root.left.val, depth + 1);
                parentMap.put(root.left.val, root);
                l = dfs(root.left, x, y, depthMap, parentMap, depth + 1);
            }
            boolean r = false;
            if (root.right != null) {
                depthMap.put(root.right.val, depth + 1);
                parentMap.put(root.right.val, root);
                r = dfs(root.right, x, y, depthMap, parentMap, depth + 1);
            }
            return l || r;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}