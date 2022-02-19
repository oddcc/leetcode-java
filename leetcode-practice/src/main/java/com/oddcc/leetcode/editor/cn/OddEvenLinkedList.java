// 328

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
        System.out.println(solution.oddEvenList(ListNode.getNodeList(1, 2, 3, 4, 5)));
        System.out.println(solution.oddEvenList(ListNode.getNodeList(2, 1, 3, 5, 6, 4, 7)));
        System.out.println(solution.oddEvenList(ListNode.getNodeList(1, 2, 3)));
        System.out.println(solution.oddEvenList(ListNode.getNodeList()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 链表的奇数元素排前面，偶数元素排后面，这里链表头视为1号节点
        // 思路1，一次遍历，要移动的节点和要插入的位置是有规律的，1.next = 3号，2.next = 5号，3.next = 7号
        // 利用双指针，一个指向要插入的位置，一个指向要移动的节点；要移动的节点指针到末尾时结束
        // 思路2，链表拆分，拆分成odd和even两个链表，然后把even接在odd后面
        public ListNode oddEvenList(ListNode head) {
            ListNode dummyOdd = new ListNode(0);
            ListNode dummyEven = new ListNode(0);
            ListNode odd = null;
            ListNode even = null;
            int count = 1;
            while (head != null) {
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
                if (count % 2 != 0) {
                    if (odd == null) {
                        odd = tmp;
                        dummyOdd.next = odd;
                    }
                    else {
                        odd.next = tmp;
                        odd = odd.next;
                    }

                }
                else {
                    if (even == null) {
                        even = tmp;
                        dummyEven.next = even;
                    }
                    else {
                        even.next = tmp;
                        even = even.next;
                    }

                }
                count++;
            }
            if (odd != null) odd.next = dummyEven.next;
            return dummyOdd.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}