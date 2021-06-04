// 349
package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 求交集，array中可能有重复元素
        // 思路1，哈希表，先遍历nums1，再遍历nums2，如果遍历nums2时遇到哈希表中存在的元素，则加入结果集；时间复杂度O(m + n)，空间复杂度O(max(m, n))
        // 思路2，先排序，然后同时遍历nums1和nums2，如果遇到相同的，就加入结果集，移动两个指针，否则移动小的那边的指针
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0) return new int[0];
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int p1 = 0;
            int p2 = 0;
            Set<Integer> ansSet = new HashSet<>();
            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] == nums2[p2]) {
                    ansSet.add(nums1[p1]);
                    p1++;
                    p2++;
                }
                else if (nums1[p1] < nums2[p2]) {
                    p1++;
                }
                else {
                    p2++;
                }
            }
            int[] ans = new int[ansSet.size()];
            int i = 0;
            for (int num : ansSet) {
                ans[i++] = num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}