// 148
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        System.out.println(solution.sortList(ListNode.getNodeList(4, 2, 1, 3)));
        System.out.println(solution.sortList(ListNode.getNodeList(-1, 5, 3, 4, 0)));
        System.out.println(solution.sortList(ListNode.getNodeList(-1)));
        System.out.println(solution.sortList(ListNode.getNodeList()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，插入排序，类似147题，但插入排序不符合题目O(NlogN)的时间复杂度要求
        // 思路2，由logN想到二分、归并等方法；此处是排序，考虑归并
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        private ListNode mergeSort(ListNode head) {
            if (head == null) return null;
            ListNode mid = findMid(head); // 如果链表有n个元素，返回第2/n + 1（从1开始）个元素
            if (mid == head) return head;
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(mid);
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            while (left != null || right != null) {
                ListNode n;
                if (left == null) {
                    n = right;
                    right = right.next;
                    n.next = null;
                }
                else if (right == null) {
                    n = left;
                    left = left.next;
                    n.next = null;
                }
                else {
                    if (left.val < right.val) {
                        n = left;
                        left = left.next;
                    }
                    else {
                        n = right;
                        right = right.next;
                    }
                    n.next = null;
                }
                current.next = n;
                current = current.next;
            }
            return dummy.next;
        }

        private ListNode findMid(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = null;
            while (true) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
                if (fast == null || fast.next == null || fast.next.next == null) {
                    pre.next = null;
                    return slow;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}