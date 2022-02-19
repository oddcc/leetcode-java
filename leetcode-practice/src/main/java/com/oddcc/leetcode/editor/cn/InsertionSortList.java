// 147

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();
        System.out.println(solution.insertionSortList(ListNode.getNodeList(4, 2, 1, 3)));
        System.out.println(solution.insertionSortList(ListNode.getNodeList(1, 1)));
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
            ListNode pre = dummyHead; // 指向所取节点的前一个节点，方便下次获取要插入的节点
            while (pre.next != null) {
                ListNode node = pre.next;
                pre.next = node.next;
                node.next = null;
                ListNode insert = dummyHead; // 指向要插入的位置，新插入的值应该是insert.next
                // 有三种情况说明找到插入的位置了，如果不是，则继续向后找
                // 1、insert.next == null 说明没有其他元素了，当前node是最大的
                // 2、insert.next == pre.next 说明已经到了这一趟遍历的边界
                // 3、node.val < insert.next.val 说明node的位置应该再insert.next之前
                while (!(insert.next == null || insert.next.equals(pre.next) || node.val < insert.next.val)) {
                    insert = insert.next;
                }
                // 对于上述的1、2两种情况，进行插入，并把pre设为node，因为node是插入后的最大的元素
                if (insert.next == null || insert.next.equals(pre.next)) {
                    ListNode tmp = insert.next;
                    insert.next = node;
                    node.next = tmp;
                    pre = node;
                }
                // 对于上述的3，进行插入，pre不用特别操作，因为是在链表中间操作，没有影响到pre
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