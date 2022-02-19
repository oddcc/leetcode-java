// 477

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class TotalHammingDistance {
    public static void main(String[] args) {
        Solution solution = new TotalHammingDistance().new Solution();
        System.out.println(solution.totalHammingDistance(new int[]{4,14,2}));
        System.out.println(solution.totalHammingDistance(new int[]{4,14,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,找规律
    // 如果我们按位看二进制的话,看所有nums[i]的每一位，可能有m个1，n个0，其中所有1之间，汉明距离为0，所有0之间也为0
    // 会产生汉明距离的只能是1和0之间，因为计算的两个元素之间的汉明距离只和，所有m个1和n个0之间，汉明距离之和就是m*n
    // 计算所有位的汉明距离之和，再相加，就得到了结果
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int ans = 0;
            int max = Arrays.stream(nums).max().getAsInt();
            int bitLen = Integer.toBinaryString(max).length();
            for (int i = 0; i < bitLen; i++) {
                int oneCount = 0;
                int zeroCount = 0;
                for (int j = 0; j < nums.length; j++) {
                    int n = nums[j];
                    int bit = (n >>> i) & 1;
                    if (bit == 1) oneCount++;
                    else zeroCount++;
                }
                ans += oneCount * zeroCount;
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}