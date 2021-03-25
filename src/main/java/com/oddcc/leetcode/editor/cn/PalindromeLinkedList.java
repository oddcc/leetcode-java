package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1,2)));
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1,2,2,1)));
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1)));
        System.out.println(solution.isPalindrome(ListNode.getNodeList(1,1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，先存下来位置，然后再从两边遍历，时间复杂度O(n)，空间复杂度O(n)
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            List<Integer> cache = new ArrayList<>();
            while (head != null) {
                cache.add(head.val);
                head = head.next;
            }
            int left = 0;
            int right = cache.size() - 1;
            while (left < right) {
                if (cache.get(left).equals(cache.get(right))) {
                    left++;
                    right--;
                }
                else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}