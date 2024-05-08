// 350&&intersection-of-two-arrays-ii

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysII().new Solution();
        System.out.println(Arrays.toString(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Set<Integer> seenBoth = new HashSet<>();
            Map<Integer, Integer> iCount1 = new HashMap<>();
            Map<Integer, Integer> iCount2 = new HashMap<>();

            for (int i : nums1) {
                iCount1.compute(i, (k, v) -> v == null ? 1 : v + 1);
            }

            for (int i : nums2) {
                iCount2.compute(i, (k, v) -> v == null ? 1 : v + 1);
                if (iCount1.containsKey(i)) {
                    seenBoth.add(i);
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i: seenBoth) {
                int c = Math.min(iCount1.get(i), iCount2.get(i));
                for (int x = 0; x < c; x++) {
                    res.add(i);
                }
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
