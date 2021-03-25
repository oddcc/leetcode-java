// 82

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        System.out.println(solution.deleteDuplicates(ListNode.GetNodeList(1, 2, 3, 3, 4, 4, 5)));
        System.out.println(solution.deleteDuplicates(ListNode.GetNodeList(1, 1, 1, 2, 3)));
        System.out.println(solution.deleteDuplicates(ListNode.GetNodeList(1, 1, 1, 2, 3, 3, 3)));
        System.out.println(solution.deleteDuplicates(ListNode.GetNodeList(1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，维护2个节点，pre，cur，及一个标志位delCur
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = pre.next;
            boolean delCur = false; // 当cur.next == cur时，delCur=true，再删完所有后续重复节点后，要删除cur
            // cur在末尾可能也是要删掉的，所以这里cur可能为null
            while (cur != null) {
                if (cur.next != null && cur.next.val == cur.val) {
                    delCur = true;
                    cur.next = cur.next.next;
                }
                else {
                    if (delCur) {
                        pre.next = cur.next;
                        delCur = false;
                    }
                    else {
                        pre = pre.next;
                    }
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}