package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1, 2)));
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1, 2, 2, 1)));
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1)));
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1, 1)));
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1, 1, 0)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，先存下来位置，然后再从两边遍历，时间复杂度O(n)，空间复杂度O(n)
        // 思路2，找到中点，反转后半部分链表，对比之后再恢复，得到结果，空间复杂度O(1)
        // 思路3，优化思路2，找中点可以用快慢指针，不需要遍历两次
        public boolean isPalindrome(ListNode head) {
            int count = 1; // 表示要对比的Node个数
            ListNode slow = head;
            ListNode quick = head;
            while (quick.next != null && quick.next.next != null) {
                slow = slow.next;
                quick = quick.next.next;
                count++;
            }
            // 说明整个链表长度为奇数
            if (quick.next == null) {
                count--;
            }
            // 反转右半部分
            ListNode r = slow.next;
            slow.next = null;
            ListNode reverseHead = reverse(r);

            // 跟左半部分做对比
            boolean ans = true;
            for (int i = 0; i < count; i++) {
                if (head.val != reverseHead.val) {
                    ans = false;
                    break;
                }
                head = head.next;
                reverseHead = reverseHead.next;
            }
            slow.next = reverse(reverseHead); // 恢复链表
            return ans;
        }

        private ListNode reverse(ListNode r) {
            ListNode pre = null;
            while (r != null) {
                ListNode t = r.next;
                r.next = pre;
                pre = r;
                r = t;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}