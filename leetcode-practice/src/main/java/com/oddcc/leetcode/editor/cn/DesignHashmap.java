// 706

package com.oddcc.leetcode.editor.cn;

public class DesignHashmap {
    public static void main(String[] args) {
        DesignHashmap obj = new DesignHashmap();
        obj.test();
    }

    private void test() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {
        // 最简单的就是仿照Java的HashMap实现，不考虑扩容，不考虑树化，就用数组+链表
        private Node[] buckets;

        private class Node {
            private Node next;
            private int key;
            private int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        /** Initialize your data structure here. */
        public MyHashMap() {
            this.buckets = new Node[1 << 10];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int h = hash(key);
            Node n = this.buckets[h];
            if (n == null) {
                n = new Node(key, value);
                this.buckets[h] = n;
            }
            else {
                if (n.key == key) {
                    n.val = value;
                }
                else {
                    Node pre = n;
                    while (pre.next != null) {
                        if (pre.next.key == key) {
                            pre.next.val = value;
                            break;
                        }
                        pre = pre.next;
                    }
                    if (pre.next == null) {
                        pre.next = new Node(key, value);
                    }
                }
            }
        }

        private int hash(int key) {
            return key & (this.buckets.length - 1);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            Node n = this.buckets[hash(key)];
            while (n != null) {
                if (n.key == key) return n.val;
                n = n.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int h = hash(key);
            Node n = this.buckets[h];
            Node dummyHead = new Node(-1, -1);
            dummyHead.next = n;
            Node pre = dummyHead;
            while (pre.next != null) {
                if (pre.next.key == key) {
                    pre.next = pre.next.next;
                }
                else {
                    pre = pre.next;
                }
            }
            this.buckets[h] = dummyHead.next;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}