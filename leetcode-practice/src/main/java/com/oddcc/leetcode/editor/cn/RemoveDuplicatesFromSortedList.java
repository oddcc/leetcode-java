// 83
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        System.out.println(solution.deleteDuplicates(ListNode.getNodeList(1,1,2,3,3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历链表，如果碰到一样的就删掉
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while (cur != null) {
                if (cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
                else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}