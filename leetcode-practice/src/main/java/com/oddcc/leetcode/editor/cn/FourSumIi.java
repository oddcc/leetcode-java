// 454

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FourSumIi {
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        System.out.println(solution.fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，如果A的长度是N，则复杂度是O(N^4)，肯定是不行的
        // 回溯，跟暴力没区别，而且题目不要求所有结果，pass
        // 先排序，暴力+剪枝，排序对剪枝没有太大帮助，因为后面有什么数字也不知道，只有到最后一步才有机会剪枝
        // 哈希表存储结果，把重复计算转为查表，容易想到的是O(N^3)的方案，正确答案是O(N^2)的方案，一步之遥
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int a : A) {
                for (int b : B) {
                    if (cache.containsKey(a + b)) {
                        cache.put(a + b, cache.get(a + b) + 1);
                    }
                    else {
                        cache.put(a + b, 1);
                    }
                }
            }
            int ans = 0;
            for (int c : C) {
                for (int d : D) {
                    if (cache.containsKey(-(c + d))) ans += cache.get(-(c + d));
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}