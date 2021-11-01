// 575

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static void main(String[] args) {
        Solution solution = new DistributeCandies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，哈希表
    class Solution {
        public int distributeCandies(int[] candyType) {
            Set<Integer> cache = new HashSet<>();
            for (int i : candyType) {
                cache.add(i);
            }
            return Math.min(candyType.length / 2, cache.size());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}