// 328

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
        System.out.println(solution.oddEvenList(ListNode.GetNodeList(1, 2, 3, 4, 5)));
        System.out.println(solution.oddEvenList(ListNode.GetNodeList(2,1,3,5,6,4,7)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 链表的奇数元素排前面，偶数元素排后面，这里链表头视为1号节点
        // 思路1，一次遍历，要移动的节点和要插入的位置是有规律的，1.next = 3号，2.next = 5号，3.next = 7号
        // 利用双指针，一个指向要插入的位置，一个指向要移动的节点；要移动的节点指针到末尾时结束
        public ListNode oddEvenList(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            // 当fastCount = slowCount * 2 + 1时执行交换
            int slowCount = 1; // 每次交换后+1
            int fastCount = 1; // 不满足上面的交换条件时就+1
            // 当fastCount = slowCount * 2 + 1 - 1时，当前节点设为fastPre，用于随后的交换
            ListNode fastPre = head;
            while (fast != null) {
                if (fastCount == slowCount * 2) fastPre = fast;
                if (fastCount == slowCount * 2 + 1) {
                    doSwap(slow, fast, fastPre);
                    slow = slow.next;
                    fast = fastPre; // 画图容易理解，也可以理解为前面插入了一个节点，fastPre就变成了新的fast开始的位置
                    slowCount++;
                }
                else {
                    fast = fast.next;
                    fastCount++;
                }
            }
            return head;
        }

        /**
         * 另node移动到insertBehind.next，并不改变链表的其他位置
         * @param insertBehind
         * @param node
         * @param preNode
         */
        private void doSwap(ListNode insertBehind, ListNode node, ListNode preNode) {
            preNode.next = node.next;
            ListNode tmp = insertBehind.next;
            insertBehind.next = node;
            node.next = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}