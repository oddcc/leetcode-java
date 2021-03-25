// 92

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        System.out.println(solution.reverseBetween(ListNode.getNodeList(1, 2, 3, 4, 5), 2, 4));
        System.out.println(solution.reverseBetween(ListNode.getNodeList(5), 1, 1));
        System.out.println(solution.reverseBetween(ListNode.getNodeList(3, 5), 1, 2));
        System.out.println(solution.reverseBetween(ListNode.getNodeList(1, 2, 3, 4), 1, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 链表如何倒置？
        // 思路1，利用辅助数组，记录链表节点的位置，直接修改链表节点的值
        // 思路2，把链表分为3部分，反转中间部分，然后拼接
        // 思路3，使用递归来反转中间部分
        // 思路4，一次遍历，利用头插法来反转链表，每次遇到新的节点，就插到链表头，就是头插法，遍历完成之后链表自然是反转的
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p = dummy;
            // 找到链表头，即每次插入的位置是p.next
            for (int i = 0; i < left - 1; i++) {
                p = p.next;
            }
            // 找到后p就固定了，之后从p.next开始，还要遍历right - left + 1个节点，其中最初的p.next不用遍历，因为其实不用移动，所以下面是right - left
            ListNode pre = p.next;
            for (int i = 0; i < right - left; i++) {
                ListNode cur = pre.next;
                // 这里建议画图理解，在插入完成后，cur在p.next的位置，而pre在原来cur的位置
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}