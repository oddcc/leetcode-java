//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 动态规划 
// 👍 1242 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(45));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Integer> cache = new HashMap<>();
        public int climbStairs(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            int n1 = 0;
            int k1 = n - 1;
            if (cache.containsKey(k1)) {
                n1 = cache.get(k1);
            } else {
                n1 = climbStairs(k1);
                cache.put(k1, n1);
            }

            int n2 = 0;
            int k2 = 0;
            if (cache.containsKey(k2)) {
                n2 = cache.get(k2);
            } else {
                n2 = climbStairs(k2);
                cache.put(k2, n2);
            }
            return n1 + n2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}