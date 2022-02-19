// 1711

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public static void main(String[] args) {
        Solution solution = new CountGoodMeals().new Solution();
        System.out.println(solution.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，类似two sum，用哈希表记录所有存在的数字和个数，然后遍历这个哈希表
    // 事先生成范围内所有2的次方数x，确定一个a，然后找b，b==x-a，如果有的话，就是一个组合问题
    class Solution {
        private final static int M = 1000000007;

        public int countPairs(int[] deliciousness) {
            int maxVal = 0;
            for (int val : deliciousness) {
                maxVal = Math.max(maxVal, val);
            }
            int maxSum = maxVal * 2;
            int ans = 0;
            Map<Integer, Integer> seenCountMap = new HashMap<>();
            for (int val : deliciousness) {
                // 对所有可能的2的次方的值进行判断
                for (int sum = 1; sum <= maxSum; sum *= 2) {
                    int count = seenCountMap.getOrDefault(sum - val, 0);
                    ans = (ans + count) % M;
                }
                seenCountMap.put(val, seenCountMap.getOrDefault(val, 0) + 1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}