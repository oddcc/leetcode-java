// 503

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，如果题目不是循环数组的话，则通过单调队列可以方便的求解，但题目是循环数组，所以当一次遍历完成之后
        // 没找到更大数字的也能确定是不是没有
        // 只要遍历两次，就一定能确定
        public int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            Deque<Integer> s = new LinkedList<>(); // 数字的索引值
            int[] ans = new int[len];
            Arrays.fill(ans, -1); // 因为遍历两次一定能出结果，所以默认值就是-1，不需要再遍历单调栈中剩余元素来确定了（也无法确定）
            for (int i = 0; i < len * 2; i++) {
                int index = i < len ? i : i - len;
                while (s.peek() != null && nums[s.peek()] < nums[index]) {
                    ans[s.pop()] = nums[index];
                }
                s.push(index);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}