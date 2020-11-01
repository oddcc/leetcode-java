package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 一个哈希表，记录对应数字上一次出现的位置，如果遇到相同的数字出现，就跟上一次的位置对比，如果<=k，则返回true，否则记录这次的位置，继续往下找
        // 如果找完了都没有发现符合条件的，则返回false
        // 之所以能这样做，是因为假设上一次的位置是i，当前位置是j，因为遍历是由左到右依次遍历，如果abs(i - j) <= k都不满足，j增大后就更不满足了
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer lastIndex = cache.get(nums[i]);
                if (lastIndex != null && Math.abs(lastIndex - i) <= k) {
                    return true;
                }
                else {
                    cache.put(nums[i], i);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}