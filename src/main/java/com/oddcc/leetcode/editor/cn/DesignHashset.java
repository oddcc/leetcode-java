// 705

package com.oddcc.leetcode.editor.cn;

public class DesignHashset {
    public static void main(String[] args) {
        DesignHashset test = new DesignHashset();
        test.test();
    }

    private void test() {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.remove(1);
        System.out.println(obj.contains(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        // 最简单的就是仿照Java的HashMap实现，不考虑扩容，不考虑树化，就用数组+链表
        private Node[] buckets;

        private class Node {
            private Node next;
            private int val;
        }

        /** Initialize your data structure here. */
        public MyHashSet() {
            this.buckets = new Node[1 << 10];
        }

        public void add(int key) {
            int h = hash(key);
            Node n = this.buckets[h];
            if (n == null) {
                n = new Node();
                n.val = key;
                this.buckets[h] = n;
            }
            else {
                while (n.next != null) {
                    n = n.next;
                }
                Node n1 = new Node();
                n1.val = key;
                n.next = n1;
            }

        }

        public void remove(int key) {
            int h = hash(key);
            Node n = this.buckets[h];
            Node dummyHead = new Node();
            dummyHead.val = -1;
            dummyHead.next = n;
            Node pre = dummyHead;
            while (pre.next != null) {
                if (pre.next.val == key) {
                    pre.next = pre.next.next;
                }
                else {
                    pre = pre.next;
                }
            }
            this.buckets[h] = dummyHead.next;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            Node n = this.buckets[hash(key)];
            while (n != null) {
                if (n.val == key) return true;
                n = n.next;
            }
            return false;
        }

        private int hash(int key) {
            return key & (this.buckets.length - 1);
        }
    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}