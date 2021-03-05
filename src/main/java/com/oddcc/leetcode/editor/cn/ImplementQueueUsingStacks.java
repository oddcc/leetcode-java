// 232

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        ImplementQueueUsingStacks o = new ImplementQueueUsingStacks();
        o.test();
    }

    private void test() {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        // 用两个栈实现队列，一个用来插入，一个用来临时保存插入前的栈内元素和次序
        private Deque<Integer> a;
        private Deque<Integer> b;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.a = new LinkedList<>();
            this.b = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
            a.push(x);
            while (!b.isEmpty()) {
                a.push(b.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return a.pop();
        }

        /** Get the front element. */
        public int peek() {
            return a.peek() == null ? 0 : a.peek(); // 题目没给这种情况返回什么，只能随便定一个返回0
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return a.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}