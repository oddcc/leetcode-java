// 817

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public static void main(String[] args) {
        Solution solution = new LinkedListComponents().new Solution();
        System.out.println(solution.numComponents(ListNode.getNodeList(0,1,2,3), new int[]{0,1,3}));
        System.out.println(solution.numComponents(ListNode.getNodeList(0,1,2,3,4), new int[]{0,3,1,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public int numComponents(ListNode head, int[] nums) {
            int ans = 0;
            Set<Integer> numsSet = new HashSet<>();
            Arrays.stream(nums).forEach(numsSet::add);
            boolean preExists = numsSet.contains(head.val);
            if (preExists) {
                ans++;
            }
            head = head.next;
            while (head != null) {
                boolean exists = numsSet.contains(head.val);

                if (exists) {
                    if (!preExists) {
                        ans++;
                    }
                    preExists = true;
                } else {
                    preExists = false;
                }

                head = head.next;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}