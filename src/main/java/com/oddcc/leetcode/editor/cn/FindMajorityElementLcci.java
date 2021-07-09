// 面试题 17.10

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FindMajorityElementLcci {
    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
        System.out.println(solution.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(solution.majorityElement(new int[]{3, 2}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，排序+计数
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int target = nums.length / 2 + 1;
            Integer pre = null;
            int count = 0;
            for (int n : nums) {
                if (pre == null) {
                    pre = n;
                    count++;
                }
                else {
                    if (pre == n) {
                        count++;
                    }
                    else {
                        pre = n;
                        count = 1;
                    }
                }
                if (count >= target) return n;
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}