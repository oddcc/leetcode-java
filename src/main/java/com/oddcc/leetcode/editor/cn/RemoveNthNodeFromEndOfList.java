//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// Follow up: Could you do this in one pass? 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1013 👎 0


package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode n1 = solution.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        ListNode n2 = solution.removeNthFromEnd(new ListNode(1), 1);
        ListNode n3 = solution.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);
        System.out.println(n1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 遍历时把位置记下来，删除的时候就不用二次遍历，时间复杂度O(n)，空间复杂度O(n)
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;
            ListNode current = head;
            List<ListNode> cache = new ArrayList<>();
            while (current != null) {
                cache.add(current);
                current = current.next;
            }
            // 删除节点
            int nIndex = cache.size() - n;
            // 删除的是头节点
            if (nIndex == 0) {
                head = head.next;
            }
            // 删除的是尾节点
            else if (nIndex == cache.size() - 1) {
                cache.get(nIndex - 1).next = null;
            }
            // 删除的是普通节点
            else {
                cache.get(nIndex - 1).next = cache.get(nIndex + 1);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}