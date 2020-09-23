//Given two binary trees, write a function to check if they are the same or not.
// 
//
// Two binary trees are considered the same if they are structurally identical a
//nd the nodes have the same value. 
//
// Example 1: 
//
// 
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
// 
//
// Example 2: 
//
// 
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
// 
//
// Example 3: 
//
// 
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
// 
// Related Topics 树 深度优先搜索 
// 👍 473 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
        TreeNode n = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5,
                                null,
                                new TreeNode(8)
                        ),
                        new TreeNode(6)
                ),
                new TreeNode(2,
                        null,
                        new TreeNode(7,
                                new TreeNode(9),
                                new TreeNode(10)
                        )
                )
        );
//        TreeNode.leftWalk(n);
//        TreeNode.midWalk(n);
//        TreeNode.rightWalk(n);
//        TreeNode.midWalkRecursion(n);
//        TreeNode.leftWalkRecursion(n);
//        TreeNode.rightWalkRecursion(n);

        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(t1, t2));

        TreeNode t3 = new TreeNode(1, new TreeNode(2), null);
        TreeNode t4 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.isSameTree(t3, t4));

        TreeNode t5 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode t6 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        System.out.println(solution.isSameTree(t5, t6));

//        System.out.println(solution.isSameTree(new TreeNode(1), null));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (!valid(p, q)) return false;
            if (p == null) return true;
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        private boolean valid(TreeNode t1, TreeNode t2) {
            if (t1 == null) return t2 == null;
            return t2 != null;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        // 中序遍历一棵树
        public static void midWalk(TreeNode n) {
            Deque<TreeNode> stack = new LinkedList<>();
            while (n != null) {
                // 有左子树时，当前结点入栈，然后遍历左子树
                if (n.left != null) {
                    stack.push(n);
                    n = n.left;
                }
                // 没有左子树时，输出当前结点
                else {
                    System.out.println(n.val);
                    // 没有左子树，有右子树时，遍历右子树
                    if (n.right != null) {
                        n = n.right;
                    }
                    else {
                        // 没有左子树和右子树，出栈，并遍历出栈结点的右子树
                        if (stack.peek() != null) {
                            TreeNode tmp = (TreeNode) stack.pop();
                            System.out.println(tmp.val);
                            if (tmp.right != null) {
                                n = tmp.right;
                            }
                        }
                        // 没有子树，栈也为空，说明遍历完成了
                        else {
                            n = null;
                        }
                    }
                }
            }
        }

        public static void midWalkRecursion(TreeNode n) {
            if (n == null) return;
            midWalkRecursion(n.left);
            System.out.println(n.val);
            midWalkRecursion(n.right);
        }

        // 前序遍历一棵树
        public static void leftWalk(TreeNode n) {
            Deque<TreeNode> stack = new LinkedList<>();
            while (n != null) {
                // 先输出当前结点
                System.out.println(n.val);
                // 有左子树时，当前结点入栈，然后遍历左子树
                if (n.left != null) {
                    stack.push(n);
                    n = n.left;
                }
                else {
                    // 没有左子树，有右子树时，遍历右子树
                    if (n.right != null) {
                        n = n.right;
                    }
                    else {
                        // 没有左子树和右子树，出栈，并遍历出栈结点的右子树
                        if (stack.peek() != null) {
                            TreeNode tmp = (TreeNode) stack.pop();
                            if (tmp.right != null) {
                                n = tmp.right;
                            }
                        }
                        // 没有子树，栈也为空，说明遍历完成了
                        else {
                            n = null;
                        }
                    }
                }
            }
        }

        public static void leftWalkRecursion(TreeNode n) {
            if (n == null) return;
            System.out.println(n.val);
            leftWalkRecursion(n.left);
            leftWalkRecursion(n.right);
        }

        // 后序遍历一棵树 todo
        public static void rightWalk(TreeNode n) {
            Deque<TreeNode> stack = new LinkedList<>();
            Deque<Integer> result = new LinkedList<>();
            while (n != null) {
                result.push(n.val);
                if (n.right != null) {
                    stack.push(n);
                    n = n.right;
                }
                else {
                    if (n.left != null) {
                        n = n.left;
                    }
                    else {
                        if (stack.peek() != null) {
                            TreeNode tmp = stack.pop();
                            result.push(n.val);
                            if (tmp.left != null) {
                                n = tmp.left;
                            }
                        }
                        else {
                            n = null;
                        }
                    }
                }
            }
            while (!result.isEmpty()) {
                System.out.println(result.pop());
            }
        }

        public static void rightWalkRecursion(TreeNode n) {
            if (n == null) return;
            rightWalkRecursion(n.left);
            rightWalkRecursion(n.right);
            System.out.println(n.val);
        }
    }
}