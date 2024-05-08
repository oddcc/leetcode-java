// 剑指 Offer 06&&cong-wei-dao-tou-da-yin-lian-biao-lcof

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        System.out.println(Arrays.toString(solution.reversePrint(ListNode.getNodeList(1, 2, 3, 4, 5))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，要求打印，可以利用栈来做，时间复杂度O(N)，空间复杂度O(N)
        // 思路2，一次遍历反转链表再输出，时间复杂度O(N)，空间复杂度O(1)，只有输出的时候需要额外空间
        public int[] reversePrint(ListNode head) {
            if (head == null) return new int[]{};
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            List<Integer> list = new ArrayList<>();
            while (pre != null) {
                list.add(pre.val);
                pre = pre.next;
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}