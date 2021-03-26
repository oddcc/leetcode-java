// 剑指 Offer 09

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        YongLiangGeZhanShiXianDuiLieLcof obj = new YongLiangGeZhanShiXianDuiLieLcof();
        obj.test();
    }

    private void test() {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        // 思路1，s0和s1两个栈，当入栈时，如果s0不为空，则所有元素pop，然后push进s1，把新元素push进s0，然后再把s1中所有元素pop，push进s0

        private Deque<Integer> s0;
        private Deque<Integer> s1;

        public CQueue() {
            s0 = new LinkedList<>();
            s1 = new LinkedList<>();
        }

        public void appendTail(int value) {
            while (!s0.isEmpty()) {
                s1.push(s0.pop());
            }
            s0.push(value);
            while (!s1.isEmpty()) {
                s0.push(s1.pop());
            }
        }

        public int deleteHead() {
            if (s0.isEmpty()) {
                return -1;
            }
            return s0.pop();
        }
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}