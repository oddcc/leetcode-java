//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Notice that you should not modify the linked list. 
//
// Follow up: 
//
// Can you solve it using O(1) (i.e. constant) memory? 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// pos is -1 or a valid index in the linked-list. 
// 
// Related Topics 链表 双指针 
// 👍 696 👎 0


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