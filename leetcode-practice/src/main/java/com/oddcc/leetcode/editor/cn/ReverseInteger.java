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
        System.out.println(solution.reverse(1534236469));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，按位处理，然后反转
    // 思路2，思路1用到了long，这是题目不允许的
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
            int ans = 0;
            for (int i = 0; i < digits.size(); i++) {
                ans += negative ? -digits.get(i) : digits.get(i);
                if (i != digits.size() - 1) {
                    int tmp = 0;
                    for (int n = 0; n < 10; n++) {
                        tmp += ans;
                        if ((negative && tmp > 0) || (!negative && tmp < 0)) return 0;
                    }
                    ans = tmp;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}