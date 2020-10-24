package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，记录访问过的数，哈希表；时间复杂度O(n)，空间复杂度O(n)
        // 思路2，先排序，然后从头遍历，时间复杂度O(nlogn)，空间复杂度取决于排序算法的实现
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            Integer tmp = null;
            for (int i : nums) {
                if (tmp == null) {
                    tmp = i;
                    continue;
                }
                else {
                    if (tmp == i) {
                        return true;
                    }
                    tmp = i;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}