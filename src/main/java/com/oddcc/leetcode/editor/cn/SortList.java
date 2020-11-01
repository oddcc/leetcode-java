package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
//        ListNode n1 = ListNode.GetNodeList(4,2,1,3);
        ListNode n1 = ListNode.GetNodeList(-1,5,3,4,0);
        ListNode n2 = solution.sortList(n1);
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，一次遍历，类似插入排序
        public ListNode sortList(ListNode head) {
            ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
            while (head != null) {
                ListNode current = head;
                head = head.next;
                current.next = null;
                ListNode insert = findLastSmaller(dummyNode, current);
                insertBehind(insert, current);
            }
            return dummyNode.next;
        }

        private void insertBehind(ListNode insert, ListNode current) {
            ListNode tmp = insert.next;
            insert.next = current;
            current.next = tmp;
        }

        // 遍历dummyNode，找到第一个小于current的节点
        private ListNode findLastSmaller(ListNode dummyNode, ListNode current) {
            ListNode lastSmaller = null;
            while (dummyNode.next != null) {
                if (dummyNode.next.val > current.val) {
                    lastSmaller = dummyNode;
                    break;
                }
                else {
                    dummyNode = dummyNode.next;
                }
            }
            if (lastSmaller == null) return dummyNode;
            return lastSmaller;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}