// 430

package com.oddcc.leetcode.editor.cn;

public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenAMultilevelDoublyLinkedList().new Solution();
        Node n1 = new Node(1,
                null,
                new Node(2, null, null, null),
                new Node(3, null, null, null)
        );
        System.out.println(solution.flatten(n1));
        Node n2 = new Node(1,
                null,
                null,
                new Node(2, null, null, new Node(3, null, null, null))
        );
        System.out.println(solution.flatten(n2));
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,遍历,利用递归来完成处理
    class Solution {
        public Node flatten(Node head) {
            if (head == null) return null;
            flattenTail(head, null);
            return head;
        }

        /**
         * flatten node list, and return tail
         * @param head assert not null
         * @param prev
         * @return
         */
        private Node flattenTail(Node head, Node prev) {
            if (head == null) return null;
            head.prev = prev;
            // next或child不为null的时候,还有处理的空间
            while (head.next != null || head.child != null) {
                // 如果child是null了,又跑到这里,则next不为null
                // 这种状态,node之间的关系都不用变,往后处理就可以
                if (head.child == null) {
                    head = head.next;
                    continue;
                }
                // 这种状态,child存在,把child当作head,flat链表,返回链表的tail
                // 返回的tail必然不是null
                Node tail = flattenTail(head.child, head);
                // 先备份之前的next
                Node next = head.next;
                // next指向child,因为接下来必然是child
                head.next = head.child;
                // 原本的child设为null
                head.child = null;

                // 如果next不是null的话,让next.prev指向返回的tail;让tail.next指向next
                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
                head = head.next;
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}