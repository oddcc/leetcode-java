// 225

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ImplementStackUsingQueues {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;
        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.remove();
        }

        /** Get the top element. */
        public int top() {
            return q1.element();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}