// 217

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> cache = new HashSet<>();
            for (int i : nums) {
                if (cache.contains(i)) return true;
                cache.add(i);
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}