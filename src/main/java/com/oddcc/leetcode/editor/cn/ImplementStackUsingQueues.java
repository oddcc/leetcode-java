// 225

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack solution = new ImplementStackUsingQueues().new MyStack();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        private int point = -1;
        private List<Integer> array;

        /** Initialize your data structure here. */
        public MyStack() {
            array = new ArrayList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            array.add(x);
            point++;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return array.remove(point--);
        }

        /** Get the top element. */
        public int top() {
            return array.get(point);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return array.isEmpty();
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