// 202

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        System.out.println(solution.isHappy(19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 按题意来写即可，关键是，如果不是的话，如何进行快速失败？即什么时候才能判断这个数不是happy number？
        // 如果出现了某种循环，则认为可以结束了
        public boolean isHappy(int n) {
            Set<Integer> shown = new HashSet<>();
            while (true) {
                if (shown.contains(n)) return false;
                if (n == 1) break;
                shown.add(n);
                n = nextNumber(n);
            }
            return true;
        }

        private int nextNumber(int n) {
            int total = 0;
            while (n > 0) {
                int tmp = n % 10;
                n = (n - tmp) / 10;
                total += tmp * tmp;
            }
            return total;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}