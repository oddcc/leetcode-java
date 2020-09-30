//Write a program to find the node at which the intersection of two singly linke
//d lists begins. 
//
// For example, the following two linked lists: 
//
//
// begin to intersect at node c1. 
//
// 
//
// Example 1: 
//
//
// 
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. F
//rom the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the inter
//sected node in A; There are 3 nodes before the intersected node in B. 
//
// 
//
// Example 2: 
//
//
// 
//Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Reference of the node with value = 2
//Input Explanation: The intersected node's value is 2 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. F
//rom the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
// node in A; There are 1 node before the intersected node in B.
// 
//
// 
//
// Example 3: 
//
//
// 
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: null
//Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B
//, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 
//0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
// 
//
// Notes: 
//
// 
// If the two linked lists have no intersection at all, return null. 
// The linked lists must retain their original structure after the function retu
//rns. 
// You may assume there are no cycles anywhere in the entire linked structure. 
// Each value on each linked list is in the range [1, 10^9]. 
// Your code should preferably run in O(n) time and use only O(1) memory. 
// 
// Related Topics 链表 
// 👍 833 👎 0


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