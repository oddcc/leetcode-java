// 173

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        BinarySearchTreeIterator obj = new BinarySearchTreeIterator();
        obj.test();
    }

    private void test() {
        // BSTIterator bstIterator = new BSTIterator(new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20))));
        BSTIterator bstIterator = new BSTIterator(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)));
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        // System.out.println(bstIterator.hasNext());
        // System.out.println(bstIterator.next());
        // System.out.println(bstIterator.hasNext());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，先中序遍历一遍，存结果，然后迭代
    // 思路2，利用栈
    class BSTIterator {
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            if (root == null) {
                return;
            }
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            if (!hasNext()) throw new RuntimeException("not has next element");
            TreeNode cur = stack.pop();
            int ans = cur.val;
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            return ans;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}