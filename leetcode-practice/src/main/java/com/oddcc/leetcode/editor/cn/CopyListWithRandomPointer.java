// 138

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        System.out.println(solution.copyRandomList(CopyListWithRandomPointer.getNodeList(new Integer[]{null, 0, 4, 2, 0}, 7, 13, 11, 10, 1)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，链表的next还是正常的，只是random需要额外处理
    // 可以用哈希表记住两个链表对应位置的节点，第一次创建完成之后，再遍历一次处理random指针
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Map<Node, Integer> originListMap = new HashMap<>();
            Map<Integer, Node> newListMap = new HashMap<>();
            Node originHead = head;
            Node newHead = null;
            Node ans = null;
            // 第一次遍历，创建新的list（不处理random和next），并把Node对应的位置记下来
            for (int i = 0; head != null; i++, head = head.next, newHead = newHead.next) {
                newHead = new Node(head.val);
                if (i == 0) ans = newHead;
                originListMap.put(head, i);
                newListMap.put(i, newHead);
            }
            // 第二次遍历，设置next和random
            newHead = ans;
            head = originHead;
            for (int i = 0; head != null; i++, head = head.next, newHead = newHead.next) {
                newHead.next = newListMap.get(i + 1);
                newHead.random = newListMap.get(originListMap.get(head.random));
            }

            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static Node getNodeList(Integer[] randomPoints, Integer... array) {
        if (randomPoints.length != array.length) throw new RuntimeException("input not valid");
        if (array.length == 0) return null;
        Node ans = null;
        Node head = ans;
        Map<Integer, Node> indexMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (head == null) {
                head = new Node(array[i]);
                ans = head;
            }
            else {
                head.next = new Node(array[i]);
                head = head.next;
            }
            indexMap.put(i, head);
        }
        head = ans;
        for (Integer r : randomPoints) {
            if (r != null) {
                head.random = indexMap.get(r);
            }
            head = head.next;
        }
        return ans;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }


    }

}