// 137

package com.oddcc.leetcode.editor.cn;

public class SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(solution.singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，哈希表+计数
        // 思路2，位运算
        public int singleNumber(int[] nums) {
            int[] bitCount = new int[32];
            for (int i = 0; i < 32; i++) {
                for (int n : nums) {
                    bitCount[i] += n >> i & 1; // 看看第i位上是不是1，计算1的数量
                    bitCount[i] = bitCount[i] % 3; // 到3就归零
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean negative = bitCount[31] == 1;
            if (negative) {
                sb.append("0");
                for (int i = 30; i >= 0; i--) {
                    if (bitCount[i] == 1) sb.append(0);
                    if (bitCount[i] == 0) sb.append(1);
                }
                return -(Integer.parseInt(sb.toString(), 2) + 1);
            }
            else {
                for (int i = 31; i >= 0; i--) sb.append(bitCount[i]);
                return Integer.parseInt(sb.toString(), 2);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}