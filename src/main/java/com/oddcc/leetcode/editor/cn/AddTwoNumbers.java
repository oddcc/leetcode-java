//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics 链表 数学 
// 👍 5034 👎 0


package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
//        ListNode n1 = solution.addTwoNumbers(new ListNode(0), new ListNode(0));
//        ListNode n2 = solution.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
        ListNode n3 = solution.addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9))), new ListNode(9, new ListNode(9)));
        System.out.println("success");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 模拟手动加法，需要注意的有几个，1是循环结束后，如果还有carry要记得处理，2是空指针的处理，3是循环开始和循环结束的条件
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode ans = null;
            ListNode n = null;
            while (l1 != null || l2 != null) {
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
                if (sum >= 10) {
                    carry = 1;
                    sum = sum - 10;
                } else {
                    carry = 0;
                }
                if (n == null) {
                    ans = new ListNode(sum);
                    n = ans;
                }
                else {
                    n.next = new ListNode(sum);
                    n = n.next;
                }
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if (carry == 1) {
                n.next = new ListNode(carry);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}