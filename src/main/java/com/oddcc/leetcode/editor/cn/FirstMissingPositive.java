// 41

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，哈希表+两次遍历，建立哈希表，如果值是负数或0则忽略，如果是正数则存下来
        // 然后从1开始查找，如果遇到哈希表中不存在的值，就是答案
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                if (i > 0) set.add(i);
            }
            int ans = 1;
            while (set.contains(ans)) {
                ans++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}