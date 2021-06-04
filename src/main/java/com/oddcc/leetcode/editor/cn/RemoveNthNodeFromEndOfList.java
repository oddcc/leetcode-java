// 19
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode n1 = solution.removeNthFromEnd(ListNode.getNodeList(1, 2, 3, 4, 5), 2);
        ListNode n2 = solution.removeNthFromEnd(ListNode.getNodeList(1), 1);
        ListNode n3 = solution.removeNthFromEnd(ListNode.getNodeList(1, 2), 1);
        System.out.println(n3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 删除倒数第n个，可以让快指针比慢指针先走n步，当快指针到结尾时，慢指针指向的就是要删除的元素
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre = dummyHead;
            ListNode fast = head;
            for (int i = 1; i<= n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                head = head.next;
                pre = pre.next;
            }
            pre.next = head.next;
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}