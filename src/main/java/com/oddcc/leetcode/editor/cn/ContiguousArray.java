// 525

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0, 1, 1, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，利用前缀和数组和哈希表
    class Solution {
        public int findMaxLength(int[] nums) {
            int len = nums.length;
            int[] pre = new int[len];
            // key是加和的值，value是第一次出现的index
            Map<Integer, Integer> cache = new HashMap<>();
            // 记录得分，遇到0则-1，遇到1则+1
            int count = 0;
            int ans = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) count--;
                else count++;
                pre[i] = count;
                cache.putIfAbsent(pre[i], i);

                int x = pre[i];
                int j = cache.get(x);
                // 如果x==0，说明[0,x]的区间中，1和0的数量相等
                if (x == 0) ans = Math.max(i + 1, ans);
                // 因为j的key跟x相等，所以就有pre[i]==pre[j]
                // 说明在[j+1,i]的区间内，1和0的数量相等，数组长度应该位i-(j+1)+1 => i-j，当i==j时，表示区间为空
                ans = Math.max(i - j, ans);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}