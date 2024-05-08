// 剑指 Offer 22&&lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        System.out.println(solution.getKthFromEnd(ListNode.getNodeList(1, 2, 3, 4, 5), 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，两次遍历，先获取链表长度，再获取对应节点
        // 思路2，一次遍历+哈希表，遍历完成后直接返回对应节点
        // 思路3，遍历+链表反转，边遍历边反转，遍历完成后从尾节点开始向头部遍历k个节点，之后再把节点之后的链表反转
        // 思路4，双指针，指针1先走k-1步，然后指针2和指针1一起走，当指针1指向尾节点时，指针2指向第k个节点，即指针1和指针2相差k-1个节点
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k - 1; i++) fast = fast.next;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}