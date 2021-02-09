// 992

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
        System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
        System.out.println(solution.subarraysWithKDistinct(new int[]{2, 1, 1, 1, 2}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历所有可能的子数组，通过维护一个哈希表，来判断子数组的K值，通过滑动数组来减少重复计算
        public int subarraysWithKDistinct(int[] A, int K) {
            int len = A.length;
            int ans = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            // 遍历方向，true表示从头到尾从左到右，false表示从尾到头从右到左
            // 为true时，窗口是扩展的，为false时，窗口是收缩的
            boolean ascend = true;
            for (int i = 0; i < len; i++) {
                if (ascend) {
                    for (int end = i; end < len; end++) {
                        countMap.put(A[end], countMap.getOrDefault(A[end], 0) + 1);
                        if (countMap.size() == K) ans++;
                    }
                    countMap.put(A[i], countMap.get(A[i]) - 1);
                    if (countMap.get(A[i]) == 0) countMap.remove(A[i]);
                    ascend = false;
                }
                else {
                    for (int end = len - 1; end >= i; end--) {
                        if (countMap.size() == K) ans++;
                        countMap.put(A[end], countMap.get(A[end]) - 1);
                        if (countMap.get(A[end]) == 0) countMap.remove(A[end]);
                    }
                    ascend = true;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}