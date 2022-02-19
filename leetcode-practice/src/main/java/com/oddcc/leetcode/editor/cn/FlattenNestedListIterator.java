// 341

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class FlattenNestedListIterator {
    public static void main(String[] args) {

    }

    // fake class for compile
    public class NestedInteger {
        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 0;
        }

        public List<NestedInteger> getList() {
            return Collections.emptyList();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    // 关键是如何记录当前访问的位置
    // 思路1，考虑递归调用，利用栈来辅助迭代
    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> stack = new LinkedList<>();

        public NestedIterator(List<NestedInteger> list) {
            for (int i = list.size() - 1; i >= 0; i--) {
                NestedInteger item = list.get(i);
                stack.push(item);
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty()) {
                return false;
            }
            NestedInteger item = stack.peek();
            if (item.isInteger()) {
                return true;
            }
            List<NestedInteger> list = stack.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
            return hasNext();
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}