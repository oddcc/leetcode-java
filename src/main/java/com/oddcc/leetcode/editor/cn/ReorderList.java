package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        ListNode n1 = ListNode.GetNodeList(1, 2, 3, 4);
        ListNode n2 = ListNode.GetNodeList(1, 2, 3, 4, 5);
        solution.reorderList(n1);
        solution.reorderList(n2);
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 因为要反复取链表的最后一个节点，可以先把链表的位置存下来
        // 每次取末尾的元素插入，插入后指针右移一位，末尾指针左移；当指针相邻或相遇时，结束
        public void reorderList(ListNode head) {
            if (head == null) return;
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int len = list.size();
            int h = 0;
            int t = len - 1;
            while (h != t - 1 && h != t) {
                ListNode last = list.get(t);
                ListNode secondLast = list.get(t - 1);
                ListNode insert = list.get(h);
                secondLast.next = null;
                ListNode tmp = insert.next;
                insert.next = last;
                last.next = tmp;
                h++;
                t--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}