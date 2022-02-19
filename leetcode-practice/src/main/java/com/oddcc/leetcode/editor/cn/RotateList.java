// 61

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        System.out.println(solution.rotateRight(ListNode.getNodeList(1, 2, 3, 4, 5), 2));
        System.out.println(solution.rotateRight(ListNode.getNodeList(0, 1, 2), 4));
        System.out.println(solution.rotateRight(ListNode.getNodeList(1), 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，一次遍历+哈希表，一次遍历，记录节点的index，然后直接进行拼接
        // 思路2，链表成环+二次遍历，第一次遍历，得到链表原来的长度len，并使链表成环
        // 成环后再遍历len - k（k要取模）个节点，断开，并返回对应节点即可
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null) return head;
            ListNode cur = head;
            int len = 1;
            while (cur.next != null) {
                cur = cur.next;
                len++;
            }
            k = k % (len);
            if (k == 0) return head;
            cur.next = head;
            for (int i = 0; i < len - k; i++) {
                cur = cur.next;
            }
            ListNode ans = cur.next;
            cur.next = null;
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}