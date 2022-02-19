// 145

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        System.out.println(solution.postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，递归，太简单就不写了
        // 思路2，非递归
        public List<Integer> postorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            TreeNode pre = null;
            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                // cur及其左子树全部入栈
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                // root.right == null说明没有右子树了
                // pre == root.right意味着上一个输出的节点就是右子树的根，说明右子树处理完了
                if (cur.right == null || pre == cur.right) {
                    ans.add(cur.val);
                    pre = cur; // 更新上一个输出的节点
                    cur = null; // cur设为null，表示当前节点已处理完了，下次要从栈中取节点来处理
                }
                // 如果还有右子树要处理，root不能输出，重新入栈，并从右子树开始处理
                else {
                    stack.push(cur);
                    cur = cur.right;
                }

            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}