// 523

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        Solution solution = new ContinuousSubarraySum().new Solution();
        // System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        // System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        // System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，前缀和+暴力法，时间复杂度O(n^2)，空间复杂度O(n)
    // 思路2，优化思路1，转换为前缀和+哈希表
    // 有个余同定理，说的是，如果x-y=z，如果z%k==0的话，那么x%k==y%k
    // 可以利用这个定理，简化上面前缀和的验证过程
    // 如果有前缀和pre，我们可以通过pre[j] - pre[i-1]来计算nums[i,j]部分的元素和
    // 根据上面的定理，如果有pre[j]%k==pre[i-1]%k，且j-i>=2，那么就存在满足题意的答案
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int len = nums.length;
            int[] pre = new int[len];
            for (int i = 0; i < len; i++) {
                if (i == 0) pre[0] = nums[0];
                else pre[i] = pre[i - 1] + nums[i];
            }
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int remain = pre[i] % k;
                if (cache.containsKey(remain) && i - cache.get(remain) >= 2) return true;
                // 除了子数组之外，如果[0,i]的和是k的倍数，且长度大于等于2，也是答案
                if (remain == 0 && i >= 1) return true;
                cache.putIfAbsent(remain, i);
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}