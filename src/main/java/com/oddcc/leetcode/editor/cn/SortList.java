package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        System.out.println(solution.sortList(ListNode.GetNodeList(4, 2, 1, 3)));
        System.out.println(solution.sortList(ListNode.GetNodeList(-1, 5, 3, 4, 0)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 由O(NlogN)的时间复杂度要求，想到递归（logN）解法
        // 归并，涉及到拆分和合并一个链表，其中拆分需要找到链表的中点（奇数个节点，偶数个节点要找到中点靠左的点）
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            // 拆分一个链表
            ListNode midNode = getMid(head);
            ListNode tmp = midNode.next;
            midNode.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(tmp);
            return merge(l1, l2);
        }

        /**
         * 快慢指针，找到链表的中点（奇数个节点，偶数个节点要找到中点靠左的点）
         *
         * @param head
         * @return
         */
        private ListNode getMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        /**
         * 合并排序两个链表
         * @param l1
         * @param l2
         * @return
         */
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode current = dummyHead;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    current.next = l2;
                    l2 = l2.next;
                }
                else if (l2 == null) {
                    current.next = l1;
                    l1 = l1.next;
                }
                else {
                    if (l1.val < l2.val) {
                        current.next = l1;
                        l1 = l1.next;
                    }
                    else {
                        current.next = l2;
                        l2 = l2.next;
                    }
                }
                current = current.next;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}