// 147

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();
        // System.out.println(solution.insertionSortList(ListNode.GetNodeList(4, 2, 1, 3)));
        System.out.println(solution.insertionSortList(ListNode.GetNodeList(1, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用插入排序排序一个链表
        // 插入排序：每次取一个元素，插入到左边合适的位置
        public ListNode insertionSortList(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
            dummyHead.next = head;
            ListNode pre = dummyHead; // 指向current的前一个节点
            while (pre.next != null) {
                ListNode node = pre.next;
                pre.next = node.next;
                node.next = null;
                ListNode insert = dummyHead; // 指向要插入的位置，新插入的值应该是insert.next
                // 当insert.next == end时，或node.val < insert.next时，说明insert就是要插入的位置，如果不是的话insert = insert.next
                while (!(insert.next == null || insert.next.equals(pre.next) || node.val < insert.next.val)) {
                    insert = insert.next;
                }
                if (insert.next == null || insert.next.equals(pre.next)) {
                    ListNode tmp = insert.next;
                    insert.next = node;
                    node.next = tmp;
                    pre = node;
                }
                else {
                    ListNode tmp = insert.next;
                    insert.next = node;
                    node.next = tmp;
                }
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}