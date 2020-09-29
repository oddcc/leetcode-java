//Given head, the head of a linked list, determine if the linked list has a cycl
//e in it. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Return true if there is a cycle in the linked list. Otherwise, return false. 
//
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
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to t
//he 1st node (0-indexed).
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to t
//he 0th node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: false
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
// 👍 767 👎 0


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
            ListNode slow = head;
            ListNode fast = head;
            while (true) {
                slow = slow.next;
                if (fast.next == null) return false;
                fast = fast.next.next;
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