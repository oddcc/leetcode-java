// 237

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInALinkedList().new Solution();
        ListNode n1 = ListNode.getNodeList(4,5,1,9);
        solution.deleteNode(n1.next);
        System.out.println(n1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目不给访问头节点，那只能重新赋值了吧，否则没法实现
        public void deleteNode(ListNode node) {
            while (node.next.next != null) {
                node.val = node.next.val;
                node = node.next;
            }
            node.val = node.next.val;
            node.next = null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}