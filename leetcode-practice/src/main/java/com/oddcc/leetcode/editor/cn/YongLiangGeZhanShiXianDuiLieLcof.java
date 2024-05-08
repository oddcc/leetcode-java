// 剑指 Offer 09&&yong-liang-ge-zhan-shi-xian-dui-lie-lcof

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
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        // 思路1，s0和s1两个栈，当入栈时，如果s0不为空，则所有元素pop，然后push进s1，把新元素push进s0，然后再把s1中所有元素pop，push进s0
        // 思路2，in和out两个栈，当入栈时，如果in不空，则直接入栈in，如果in为空，则把out中的都pop并push进in，然后新元素入栈；
        // 当出栈时，如果out不为空，则直接从out出栈，如果out为空，则把in中元素都pop并push进out，然后out出栈
        private Deque<Integer> in;
        private Deque<Integer> out;

        public CQueue() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public void appendTail(int value) {
            if (!in.isEmpty()) {
                in.push(value);
                return;
            }
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            in.push(value);
        }

        public int deleteHead() {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            if (!out.isEmpty()) {
                return out.pop();
            }
            return -1;
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