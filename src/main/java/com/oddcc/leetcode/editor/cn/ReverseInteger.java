// 7

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，按位处理，然后反转
    class Solution {
        public int reverse(int x) {
            if (x == 0) return 0;
            boolean negative = x < 0;
            List<Integer> digits = new ArrayList<>();
            while (x != 0) {
                int i = negative ? -(x % 10) : x % 10;
                digits.add(i);
                x = x / 10;
            }
            long ans = 0;
            for (int i = 0; i < digits.size(); i++) {
                ans += digits.get(i);
                if (i != digits.size() - 1) ans *= 10;
            }
            if (negative) ans = -ans;
            return (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) ? 0 : (int) ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}