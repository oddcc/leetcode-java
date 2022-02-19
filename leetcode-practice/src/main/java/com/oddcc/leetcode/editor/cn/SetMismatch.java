// 645

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，哈希表
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] ans = new int[2];
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int i = 1; i <= n; i++) {
                int count = map.getOrDefault(i, 0);
                if (count == 2) {
                    ans[0] = i;
                }
                else if (count == 0) {
                    ans[1] = i;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}