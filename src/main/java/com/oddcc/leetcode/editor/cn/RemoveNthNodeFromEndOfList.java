//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// Follow up: Could you do this in one pass? 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1013 👎 0


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