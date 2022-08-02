// 622

package com.oddcc.leetcode.editor.cn;

public class DesignCircularQueue {
    public static void main(String[] args) {
        DesignCircularQueue solution = new DesignCircularQueue();
        solution.test();
    }

    public void test() {
        MyCircularQueue t = new MyCircularQueue(81);
        t.enQueue(69);
        t.deQueue();
        t.enQueue(92);
        t.enQueue(12);
        t.deQueue();
        t.isFull();
        t.isFull();
        t.Front();
        t.deQueue();
        t.enQueue(28);
        t.Front();
        System.out.println(t);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        private int capacity;
        private int count;
        private Node front;
        private Node rear;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.count = 0;
            this.front = null;
            this.rear = null;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            if (front == null) {
                front = new Node(value);
                rear = front;
                count++;
                return true;
            }

            Node next = new Node(value);
            rear.next = next;
            rear = next;
            count++;
            rear.next = front;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            count--;
            if (isEmpty()) {
                front = null;
                rear = null;
                return true;
            }
            Node toBeDeleted = front;
            front = front.next;
            toBeDeleted.next = null;
            rear.next = front;
            return true;
        }

        public int Front() {
            if (count == 0) {
                return -1;
            }
            return front.value;
        }

        public int Rear() {
            if (count == 0) {
                return -1;
            }
            return rear.value;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == capacity;
        }

        class Node {
            private Node next;
            private int value; // value == -1 means this Node isn't holding any data right now

            public Node(int value) {
                this.value = value;
            }
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}