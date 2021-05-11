// 1734

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class DecodeXoredPermutation {
    public static void main(String[] args) {
        Solution solution = new DecodeXoredPermutation().new Solution();
        System.out.println(Arrays.toString(solution.decode(new int[]{6, 5, 4, 6})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，直接根据encoded计算perm，异或有交换律
    class Solution {
        public int[] decode(int[] encoded) {
            int n = encoded.length+1;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total ^= i;
            }
            int odd = 0;
            for (int i = 1; i < n - 1; i += 2) {
                odd ^= encoded[i];
            }
            int[] ans = new int[n];
            ans[0] = total ^ odd;
            for (int i = 0; i < n - 1; i++) {
                ans[i + 1] = ans[i] ^ encoded[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}