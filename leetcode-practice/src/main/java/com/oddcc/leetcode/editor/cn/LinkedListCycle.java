// 141
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        System.out.println(solution.hasCycle(new ListNode(1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // 检测单链表是否有环，可以用快慢指针
        // 如果遇到null，说明肯定没有环，否则当快慢指针相遇时，就可以确定有环
        // 关于慢指针走一步，快指针走两步的情况下，为什么快慢指针一定会相遇 https://www.zhihu.com/question/23208893
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode fast = head;
            ListNode slow = head;
            while (true) {
                slow = slow.next;
                fast = fast.next == null ? null : fast.next.next;
                if (slow == null || fast == null) {
                    return false;
                }
                if (slow == fast) {
                    return true;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}