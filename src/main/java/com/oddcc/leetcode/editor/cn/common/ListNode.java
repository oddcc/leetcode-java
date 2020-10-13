package com.oddcc.leetcode.editor.cn.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode GetNodeList(Integer ...array) {
        if (array.length == 0) return null;
        ListNode ans = null;
        ListNode head = ans;
        for (Integer i: array) {
            if (head == null) {
                head = new ListNode(i);
                ans = head;
            } else {
                head.next = new ListNode(i);
                head = head.next;
            }
        }
        return ans;
    }
}
