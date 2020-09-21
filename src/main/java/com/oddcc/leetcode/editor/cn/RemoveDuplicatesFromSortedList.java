//Given a sorted linked list, delete all duplicates such that each element appea
//r only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
// 
// Related Topics 链表 
// 👍 396 👎 0


package com.oddcc.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode n = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        ListNode r = solution.deleteDuplicates(n);
        System.out.println(r);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 从头结点开始遍历，遇到重复的就删掉，需要注意的是起止条件
            // 这里用了2个结点来遍历，开始时last为null，current指向头结点；终止时last指向尾结点，current指向null
            ListNode lastNode = null;
            ListNode current = head;
            while (current != null) {
                if (lastNode == null) {
                    lastNode = current;
                    current = current.next;
                }
                else {
                    if (current.val == lastNode.val) {
                        lastNode.next = current.next;
                        current = current.next;
                    }
                    else {
                        lastNode = lastNode.next;
                        current = current.next;
                    }
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}