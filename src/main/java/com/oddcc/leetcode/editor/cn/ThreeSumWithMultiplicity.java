// 923

package com.oddcc.leetcode.editor.cn;

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        Solution solution = new ThreeSumWithMultiplicity().new Solution();
        System.out.println(solution.threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5));
        System.out.println(solution.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，根据题意，数字一定有重复，但对于结果来说a1ba2和a2ba1是两个结果
    // 所以如果我们知道a总共有2个，不用遍历，就可以通过计算来知道有几种可能
    class Solution {
        private int MOD = 1_000_000_007;

        public int threeSumMulti(int[] arr, int target) {
            long tupleCount = 0;
            long[] counts = new long[101];
            // 得出所有数字各有几个
            for (int num : arr) {
                counts[num]++;
            }
            // x < y < z的情况
            for (int x = 0; x <= 100; x++) {
                for (int y = x + 1; y <= 100; y++) {
                    int z = target - x - y;
                    if (z > y && z <= 100) {
                        tupleCount += (counts[x] * counts[y] * counts[z]);
                        tupleCount %= MOD;
                    }
                }
            }
            // x == y < z的情况
            for (int x = 0; x <= 100; x++) {
                int z = target - 2 * x;
                if (z > x && z <= 100) {
                    //selecting two items when there is  counts[y] identical items
                    tupleCount += ((counts[x] * (counts[x] - 1) / 2) * counts[z]);
                    tupleCount %= MOD;
                }
            }
            // x < y == z的情况
            for (int x = 0; x <= 100; x++) {
                int yz = target - x;
                if (yz % 2 == 0) {
                    int y = yz / 2;
                    if (y > x && y <= 100) {
                        //selecting two items when there is  counts[y] identical items
                        tupleCount += (counts[x] * (counts[y] * (counts[y] - 1) / 2));
                        tupleCount %= MOD;
                    }

                }
            }
            // x == y == z的情况
            if (target % 3 == 0) {
                int x = target / 3;
                //selective 3 items items when there is counts[x] identical items
                tupleCount += (counts[x] * (counts[x] - 1) * (counts[x] - 2)) / 6;
                tupleCount %= MOD;
            }
            return (int) tupleCount;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}