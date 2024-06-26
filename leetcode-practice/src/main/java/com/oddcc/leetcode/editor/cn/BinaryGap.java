// 868

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
    public static void main(String[] args) {
        Solution solution = new BinaryGap().new Solution();
        System.out.println(solution.binaryGap(22));
        System.out.println(solution.binaryGap(8));
        System.out.println(solution.binaryGap(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int binaryGap(int n) {
            char[] binaryStrChars = Integer.toBinaryString(n).toCharArray();
            Integer h = null;
            Integer l = null;
            int ans = 0;
            for (int i = 0; i < binaryStrChars.length; i++) {
                if (binaryStrChars[i] == '1') {
                    if (h == null) {
                        h = i;
                    } else {
                        l = i;
                        ans = Math.max(ans, l - h);
                        h = l;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}