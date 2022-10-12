// 409

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("Aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> letterMap = new HashMap<>();
            AtomicInteger ans = new AtomicInteger();
            for (Character c : s.toCharArray()) {
                letterMap.compute(c, (k, v) -> {
                    if (v == null) {
                        return 1;
                    } else {
                        if (v == 1) {
                            ans.addAndGet(2);
                            return 0;
                        } else {
                            return v + 1;
                        }
                    }
                });
            }

            if (ans.get() < s.length()) {
                ans.addAndGet(1);
            }

            return ans.get();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}