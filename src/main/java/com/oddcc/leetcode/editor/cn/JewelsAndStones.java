//You're given strings J representing the types of stones that are jewels, and S
// representing the stones you have. Each character in S is a type of stone you ha
//ve. You want to know how many of the stones you have are also jewels. 
//
// The letters in J are guaranteed distinct, and all characters in J and S are l
//etters. Letters are case sensitive, so "a" is considered a different type of sto
//ne from "A". 
//
// Example 1: 
//
// 
//Input: J = "aA", S = "aAAbbbb"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: J = "z", S = "ZZ"
//Output: 0
// 
//
// Note: 
//
// 
// S and J will consist of letters and have length at most 50. 
// The characters in J are distinct. 
// 
// Related Topics 哈希表 
// 👍 584 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();
        System.out.println(solution.numJewelsInStones("z", "ZZ"));
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法1，可以采用暴力遍历，负责度O(m * n)
        // 方法2，知道表示的都是数字，所以可以把数量存起来，时间复杂度O(m + n)
        public int numJewelsInStones(String J, String S) {
            int[] count = new int['z' - 'A' + 1];
            Arrays.fill(count, -1);
            // 把是宝石的地方标志成0
            for (int i = 0; i < J.length(); i++) {
                count[J.charAt(i) - 'A'] = 0;
            }
            // 计数
            for (int i = 0; i < S.length(); i++) {
                char s = S.charAt(i);
                if (count[s - 'A'] != -1) {
                    count[s - 'A']++;
                }
            }
            // 输出结果
            int result = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] != -1) {
                    result += count[i];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}