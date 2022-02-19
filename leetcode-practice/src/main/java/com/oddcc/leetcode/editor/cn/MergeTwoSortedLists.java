// 21

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(2, null);
//        l1.next = new ListNode(2, new ListNode(4,null));
        ListNode l2 = new ListNode(1, null);
//        l2.next = new ListNode(3, new ListNode(4,null));
        solution.mergeTwoLists(l1, l2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode result = null;
            ListNode current = null;
            // 比较l1和l2的head，把小的拼到result上，重复这个过程，直到l1或l2某一个为null，说明拼完了，这时直接把剩下的那个拼在result上
            while (true) {
                TwoNode r = null;
                if (l1 == null) {
                    current.next = l2;
                    break;
                }
                if (l2 == null) {
                    current.next = l1;
                    break;
                }
                if (l1.val < l2.val) {
                    r = pickOneNode(current, l1);
                    l1 = r.picked;
                } else {
                    r = pickOneNode(current, l2);
                    l2 = r.picked;
                }
                if (result == null) {
                    result = r.current;
                }
                current = r.current;
            }
            return result;
        }

        /**
         * 取source的head加到target之后，返回target的current和被截短的source
         * @param target
         * @param source
         * @return
         */
        private TwoNode pickOneNode(ListNode target, ListNode source) {
            if (target == null) {
                ListNode c = source;
                ListNode tmp = source.next;
                c.next = null;
                return new TwoNode(c, tmp);
            }
            if (source == null) {
                return new TwoNode(target, null);
            }
            target.next = source;
            ListNode tmp = source.next;
            ListNode c = target.next;
            c.next = null;
            return new TwoNode(c, tmp);
        }
    }

    class TwoNode {
        ListNode current;
        ListNode picked;

        public TwoNode(ListNode current, ListNode picked) {
            this.current = current;
            this.picked = picked;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}