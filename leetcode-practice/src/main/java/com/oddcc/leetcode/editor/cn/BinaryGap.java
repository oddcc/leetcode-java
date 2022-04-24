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
            List<Integer> indexOf1 = new ArrayList<>();
            for (int i = 0; i < binaryStrChars.length; i++) {
                if (binaryStrChars[i] == '1') {
                    indexOf1.add(i);
                }
            }
            indexOf1.sort(Integer::compareTo);
            int ans = 0;
            if (indexOf1.size() <= 1) {
                return ans;
            }
            for (int i = 1; i < indexOf1.size(); i++) {
                ans = Math.max(ans, indexOf1.get(i) - indexOf1.get(i - 1));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}