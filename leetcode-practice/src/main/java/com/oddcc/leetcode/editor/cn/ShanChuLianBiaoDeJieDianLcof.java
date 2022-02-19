// 剑指 Offer 18

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class ShanChuLianBiaoDeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
        System.out.println(solution.deleteNode(ListNode.getNodeList(4,5,1,9), 5));
        System.out.println(solution.deleteNode(ListNode.getNodeList(4,5,1,9), 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，一次遍历+删除指定节点
        public ListNode deleteNode(ListNode head, int val) {
            ListNode dummyNode = new ListNode(-1);
            ListNode pre = dummyNode;
            dummyNode.next = head;
            while (head != null) {
                if (head.val == val) {
                    pre.next = head.next;
                }
                head = head.next;
                pre = pre.next;
            }
            return dummyNode.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}