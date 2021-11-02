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
    // can't access head node, that means we can't get the pre of the node which need to be deleted
    // so we have to change the node value to implement node delete
    class Solution {
        public void deleteNode(ListNode node) {
            // guarantee node.next != null
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
            next.next = null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}