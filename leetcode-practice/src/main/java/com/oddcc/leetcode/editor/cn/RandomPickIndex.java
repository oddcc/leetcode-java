// 398

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class RandomPickIndex {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Set<Integer>> indexMap = new HashMap<>();

        private Map<Integer, Iterator<Integer>> iteratorCache = new HashMap<>();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if (!indexMap.containsKey(n)) {
                    indexMap.put(n, new HashSet<>());
                }
                indexMap.get(n).add(i);
            }
        }

        public int pick(int target) {
            if (!iteratorCache.containsKey(target)) {
                iteratorCache.put(target, indexMap.get(target).iterator());
            }
            Iterator<Integer> i = iteratorCache.get(target);
            if (!i.hasNext()) {
                iteratorCache.put(target, indexMap.get(target).iterator());
                i = iteratorCache.get(target);
            }
            return i.next();
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}