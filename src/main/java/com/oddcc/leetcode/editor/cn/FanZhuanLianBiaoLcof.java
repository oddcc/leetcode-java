// 剑指 Offer 24

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        System.out.println(solution.reverseList(ListNode.getNodeList(1, 2, 3, 4, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，迭代，边遍历边反转链表
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode t = head.next;
                head.next = pre;
                pre = head;
                head = t;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}