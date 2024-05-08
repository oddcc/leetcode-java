// 剑指 Offer 52&&liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，找到两个链表长度之差，让长的先走，如果有相交，则在某一时间，两个链表会走到同一个节点
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int aLen = getLen(headA);
            int bLen = getLen(headB);
            boolean isALonger = aLen >= bLen;
            int ahead = isALonger ? aLen - bLen : bLen - aLen;
            for (int i = 0; i < ahead; i++) {
                if (isALonger) {
                    headA = headA.next;
                }
                else {
                    headB = headB.next;
                }
            }
            ListNode ans = null;
            while (headA != null && headB != null) {
                if (headA == headB) {
                    ans = headA;
                    break;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return ans;
        }

        private int getLen(ListNode h) {
            int l = 0;
            while (h != null) {
                h = h.next;
                l++;
            }
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}