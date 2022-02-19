// 1629

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class SlowestKey {
    public static void main(String[] args) {
        Solution solution = new SlowestKey().new Solution();
        System.out.println(solution.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        System.out.println(solution.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char slowestKey(int[] releaseTimes, String keysPressed) {
            Set<Character> keys = new HashSet<>();
            int len = releaseTimes.length;
            int max = 0;
            keys.add(keysPressed.charAt(0));
            for (int i = 0; i < len; i++) {
                int last;
                if (i == 0) {
                    last = releaseTimes[0];
                } else {
                    last = releaseTimes[i] - releaseTimes[i - 1];
                }
                if (last > max) {
                    keys = new HashSet<>();
                    keys.add(keysPressed.charAt(i));
                    max = last;
                }
                else if (last == max) {
                    keys.add(keysPressed.charAt(i));
                }
            }
            char res = 'a';
            for (char c : keys) {
                res = (char) Math.max(res, c);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}