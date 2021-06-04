// 142

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        System.out.println(solution.detectCycle(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // 找到环，并且找到环的入口，关于如何找到 https://www.raychase.net/6104
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            ListNode fast = head;
            ListNode slow = head;
            boolean met = false;
            while (true) {
                if (fast == null || slow == null) {
                    return null;
                }
                if (!met) {
                    fast = fast.next == null ? null : fast.next.next;
                    slow = slow.next;
                    if (fast == slow) {
                        met = true;
                        fast = head;
                    }
                } else {
                    // 当快慢指针在head相遇时，是特殊情况，此时是链表的头尾相连；如果先移动节点再判断相遇，就会出错
                    if (fast == slow) {
                        return fast;
                    }
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}