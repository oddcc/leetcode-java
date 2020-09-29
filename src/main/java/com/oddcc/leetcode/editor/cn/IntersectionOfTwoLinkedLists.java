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
        // 两个链表找交点，需要遍历3次
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode nA = headA;
            int cA = 0;
            while (nA != null) {
                nA = nA.next;
                cA++;
            }
            ListNode nB = headB;
            int cB = 0;
            while (nB != null) {
                nB = nB.next;
                cB++;
            }
            nA = headA;
            nB = headB;
            if (cA == cB) {
                while (cA >= 0) {
                    if (nA == nB) {
                        return nA;
                    }
                    nA = nA.next;
                    nB = nB.next;
                    cA--;
                }
            }
            else if (cA > cB) {
                while (cA > cB) {
                    cA--;
                    nA = nA.next;
                }
                while (cA >= 0) {
                    if (nA == nB) {
                        return nA;
                    }
                    nA = nA.next;
                    nB = nB.next;
                    cA--;
                }
            }
            else {
                while (cB > cA) {
                    cB--;
                    nB = nB.next;
                }
                while (cB >= 0) {
                    if (nA == nB) {
                        return nA;
                    }
                    nA = nA.next;
                    nB = nB.next;
                    cB--;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}