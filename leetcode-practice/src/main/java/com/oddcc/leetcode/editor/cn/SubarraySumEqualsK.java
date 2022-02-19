// 560

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(solution.subarraySum(new int[]{5, 5, -10, 10, -10, 10}, 10));
        System.out.println(solution.subarraySum(new int[]{1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目没说nums是有序的
        // 思路1，暴力枚举
        // 思路2，如果定义pre[j]表示0~j的数字之和，则有pre[j - 1] = pre[j] - nums[j]
        // 由题目条件，如果[j,i]是一个和为k的子串，则有pre[i] = pre[j - 1] + k -> pre[j - 1] = pre[i] - k
        // 从而将题目转为求pre数组中的two sum问题
        // 从左向右遍历每一个位置（对应上面的i），如果有能满足pre[j - 1] = pre[i] - k的则加到答案中
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            int len = nums.length;
            int[] pre = new int[len];
            Map<Integer, Integer> preCount = new HashMap<>();
            preCount.put(0, 1);
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    pre[i] = nums[i];
                }
                else {
                    pre[i] = pre[i - 1] + nums[i];
                }
                int want = pre[i] - k;
                if (preCount.containsKey(want)) {
                    ans += preCount.get(want);
                }
                if (preCount.containsKey(pre[i])) {
                    preCount.put(pre[i], preCount.get(pre[i]) + 1);
                }
                else {
                    preCount.put(pre[i], 1);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}