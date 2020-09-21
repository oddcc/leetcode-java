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
        // 因为每一项只与之前两项有关，所以不用存储所有的中间计算结果
        // 存储固定个数个结果，可以用滚动数组法
        public int climbStairs(int n) {
            if (n == 0) return 1;
            if (n == 1) return 1;
            // n1表示n-1，n2表示n-2
            int n1 = 1;
            int n2 = 1;
            int r = 0;
            // 计算结果，并向前滚动数组，即r -> n1, n1 -> n2
            for (int i = 2; i <= n; i++) {
                r = n2 + n1;
                n2 = n1;
                n1 = r;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}