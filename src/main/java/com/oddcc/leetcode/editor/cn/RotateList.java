// 61

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

import java.util.HashMap;
import java.util.Map;

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
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null) return head;
            ListNode cur = head;
            int len = 0;
            Map<Integer, ListNode> cache = new HashMap<>();
            while (cur != null) {
                cache.put(len++, cur);
                cur = cur.next;
            }
            k = k % (len);
            if (k == 0) return head;
            int tarIndex = len - k;
            ListNode ans = cache.get(tarIndex);
            if (tarIndex - 1 >= 0) cache.get(tarIndex - 1).next = null;
            cache.get(len - 1).next = head;
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}