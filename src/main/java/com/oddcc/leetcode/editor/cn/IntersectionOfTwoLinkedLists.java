// 160
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // 链表连接法，只是逻辑上的连接，实际还是要记录每个链表的终点，用于判断结果
        // 当两个链表有交点时，假设A、B分别为起点，交点在N，终点在E；
        // 按照链表连接法，A走过的路径为 AN + NE + BN + NE，B走过的路径为 BN + NE + AN + NE；可以看到，最后一段NE不用走，两个指针会在N处相遇
        // 当两个链表没有交点时，假设A、B为起点，E、F为对应的终点
        // A走过的路径为 AE + BF，B走过的路径为 BF + AE，最后两个链表都走到了终点，但还没有遇到交点，这种情况就是没有交点
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            boolean aEnd = false;
            boolean bEnd = false;
            ListNode a = headA;
            ListNode b = headB;
            while (a != null && b != null) {
                if (a == b) {
                    return a;
                }
                a = a.next;
                if (a == null && !aEnd) {
                    a = headB;
                    aEnd = true;
                }
                b = b.next;
                if (b == null && !bEnd) {
                    b = headA;
                    bEnd = true;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}