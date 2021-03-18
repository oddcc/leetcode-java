// 92

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        System.out.println(solution.reverseBetween(ListNode.GetNodeList(1, 2, 3, 4, 5), 2, 4));
        System.out.println(solution.reverseBetween(ListNode.GetNodeList(5), 1, 1));
        System.out.println(solution.reverseBetween(ListNode.GetNodeList(3, 5), 1, 2));
        System.out.println(solution.reverseBetween(ListNode.GetNodeList(1, 2, 3, 4), 1, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 链表如何倒置？
        // 思路1，利用辅助数组，记录链表节点的位置，直接修改链表节点的值
        // 思路2，把链表分为3部分，反转中间部分，然后拼接
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy; // pre表示第一部分不变的链表尾部，可能为dummy
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }
            ListNode next = pre.next; // next表示第三部分不变的链表头部，可能为null
            for (int i = 0; i < right - left; i++) {
                next = next.next;
            }
            ListNode tmp = next.next;
            next.next = null;
            next = tmp;
            ListNode newHead = reverse(pre.next);
            pre.next.next = next;
            pre.next = newHead;
            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode tmp = head.next;
                if (pre == null) {
                    pre = head;
                    head.next = null;
                }
                else {
                    head.next = pre;
                    pre = head;
                }
                head = tmp;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}