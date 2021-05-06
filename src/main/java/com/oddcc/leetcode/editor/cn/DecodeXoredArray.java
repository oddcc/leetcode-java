// 1720

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class DecodeXoredArray {
    public static void main(String[] args) {
        Solution solution = new DecodeXoredArray().new Solution();
        System.out.println(Arrays.toString(solution.decode(new int[]{1, 2, 3}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，异或的性质是 x ⊕ x = 0
    // x ⊕ 0 = 0 ⊕ x = x
    // 题目给出了encoded[i] = arr[i] XOR arr[i + 1]
    // 我们对两边同时⊕arr[i]，就能得到arr[i+1]=encoded[i]⊕arr[i]
    class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] ans = new int[encoded.length + 1];
            ans[0] = first;
            for (int i = 1; i < encoded.length + 1; i++) {
                ans[i] = ans[i - 1] ^ encoded[i - 1];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}