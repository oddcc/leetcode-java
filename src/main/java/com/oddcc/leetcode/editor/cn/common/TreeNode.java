package com.oddcc.leetcode.editor.cn.common;

import com.oddcc.leetcode.editor.cn.SameTree;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
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
