// 496

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，栈+哈希表
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i : nums2) {
                while (!stack.isEmpty() && stack.peek() < i) {
                    cache.put(stack.pop(), i);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                cache.put(stack.pop(), -1);
            }
            int[] ans = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = cache.get(nums1[i]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}