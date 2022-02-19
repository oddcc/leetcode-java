// 179

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{10, 2}));
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution.largestNumber(new int[]{1}));
        System.out.println(solution.largestNumber(new int[]{10}));
        System.out.println(solution.largestNumber(new int[]{0, 0}));
        System.out.println(solution.largestNumber(new int[]{1, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，贪心，每次取"最大"的数字来拼接字符串即可，关键是如何得到"最大"的数字
        // 如[3,30]，最大的结果应该是330而不是303
        // 又如[3,34]，最大应该是343而不是334
        // 要注意处理前导零
        public String largestNumber(int[] nums) {
            StringBuilder ans = new StringBuilder();
            List<Integer> numList = new ArrayList<>();
            for (int num : nums) numList.add(num);
            numList.sort((n1, n2) -> {
                String s1 = n1.toString();
                String s2 = n2.toString();
                return (s2 + s1).compareTo(s1 + s2);
            });
            boolean leadingZero = true;
            for (int n : numList) {
                if (n != 0) leadingZero = false;
                if (leadingZero) continue;
                ans.append(n);
            }
            return ans.length() == 0 ? "0" : ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}