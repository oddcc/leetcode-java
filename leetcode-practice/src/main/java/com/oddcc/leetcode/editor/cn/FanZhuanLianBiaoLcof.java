// 剑指 Offer 24&&fan-zhuan-lian-biao-lcof

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        System.out.println(solution.reverseList(ListNode.getNodeList(1, 2, 3, 4, 5)));
        System.out.println(solution.reverseList(ListNode.getNodeList(1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，迭代，边遍历边反转链表
        // 思路2，递归

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode reverseHead = reverse(head.next, head);
            head.next = null;
            return reverseHead;
        }

        /**
         * 函数的作用是，反转head链表，并返回反转后的链表头
         * @param head 要反转的链表
         * @param pre head的前一个节点，可以为null
         * @return 反转后的链表头
         */
        private ListNode reverse(ListNode head, ListNode pre) {
            // head是链表的最后一个节点，反转，next指向前一个节点，并返回head
            if (head.next == null) {
                head.next = pre;
                return head;
            }
            // head不是链表的最后一个节点，把head.next之后的链表反转
            ListNode reserveHead = reverse(head.next, head);
            // 反转后，head应该是在反转后的链表尾部，指向pre完成反转
            head.next = pre;
            return reserveHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}