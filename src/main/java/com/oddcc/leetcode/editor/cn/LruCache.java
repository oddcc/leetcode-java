// 146

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
        LruCache obj = new LruCache();
        obj.test();
    }

    private void test() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private class Node {
            private int value;
            private int key; // 必须存储，因为实际操作时，有拿到Node，需要从nodeMap中删除此Node
            private Node pre;
            private Node next;
        }

        private Map<Integer, Node> nodeMap;
        private int capacity;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node();
            this.tail = new Node();
            this.head.next = this.tail;
            this.tail.pre = this.head;
            this.nodeMap = new HashMap<>();
        }

        public int get(int key) {
            Node n = nodeMap.get(key);
            if (n == null) {
                System.out.println(-1);
                return -1;
            }
            remove(n);
            insert(n);
            System.out.println(n.value);
            return n.value;
        }

        public void put(int key, int value) {
            Node n = this.nodeMap.get(key);
            if (n != null) {
                n.value = value;
                remove(n);
                insert(n);
            }
            else {
                n = new Node();
                n.value = value;
                n.key = key;
                if (this.nodeMap.size() >= this.capacity) {
                    Node e = this.tail.pre;
                    remove(e);
                    this.nodeMap.remove(e.key);
                }
                insert(n);
                this.nodeMap.put(key, n);
            }
        }

        // insert n after head
        private void insert(Node n) {
            Node tmp = this.head.next;
            this.head.next = n;
            n.next = tmp;
            tmp.pre = n;
            n.pre = this.head;
        }

        // remove n
        private void remove(Node n) {
            Node pre = n.pre;
            Node next = n.next;
            n.pre = null;
            next.pre = pre;
            n.next = null;
            pre.next = next;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}