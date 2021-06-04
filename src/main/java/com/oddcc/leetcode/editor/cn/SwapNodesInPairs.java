// 24
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
//        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode ans1 = solution.swapPairs(n1);
//        System.out.println(ans1);
//        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode ans1 = solution.swapPairs(n1);
//        System.out.println(ans1);
        ListNode n1 = ListNode.getNodeList(2, 5, 3, 4, 6, 2, 2);
        ListNode ans1 = solution.swapPairs(n1);
        System.out.println(ans1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 直接模拟，注意细节和边界条件
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode dummyHead = null;
            ListNode node = head;
            ListNode pre = null;
            ListNode post = null;
            while (node != null && node.next != null) {
                if (dummyHead == null) {
                    dummyHead = node.next;
                }
                post = node.next.next;
                node.next.next = node;
                if (pre != null) {
                    pre.next = node.next;
                }
                else {
                    pre = dummyHead.next;
                }
                node.next = post;
                if (pre != null) {
                    pre = node;
                }
                node = node.next;
            }
            return dummyHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}