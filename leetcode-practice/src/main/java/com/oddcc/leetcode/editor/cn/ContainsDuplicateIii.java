// 220

package com.oddcc.leetcode.editor.cn;

import java.util.TreeSet;

public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，滑动窗口，窗口长度最大为k+1，每次新加元素时，跟窗口内值做比较，空间复杂度O(k+1)，时间复杂度O((len-k)k)
        // 思路2，思路1中比较的过程太慢了，如果滑动窗口内可以支持范围查找的话，就很方便，比如查有没有值i，满足x<=i<=y
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int len = nums.length;
            if (len < 2 || k < 1) return false;
            TreeSet<Long> cache = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                // ceiling返回最小的大于等于传入参数的值
                // abs(x-y) <= t  就是  -t <= x-y <= t
                Long ceiling = cache.ceiling((long) nums[i] - (long) t);
                if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                    return true;
                }
                cache.add((long) nums[i]);
                if (i >= k) {
                    cache.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}