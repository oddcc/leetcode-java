// 203

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        System.out.println(solution.removeElements(ListNode.GetNodeList(1, 2, 3, 4, 5, 6), 1));
        System.out.println(solution.removeElements(ListNode.GetNodeList(1, 1), 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode pre = dummyHead;
            while (head != null) {
                // 有节点要删除时，head变，而pre不变
                if (head.val == val) {
                    pre.next = head.next;
                }
                // 没有节点要删除时，pre要变，head也要跟着变
                else {
                    pre = pre.next;
                }
                head = pre.next;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}