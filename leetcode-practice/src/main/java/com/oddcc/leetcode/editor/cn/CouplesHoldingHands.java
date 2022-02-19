// 765

package com.oddcc.leetcode.editor.cn;

public class CouplesHoldingHands {
    public static void main(String[] args) {
        Solution solution = new CouplesHoldingHands().new Solution();
        System.out.println(solution.minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(solution.minSwapsCouples(new int[]{3, 2, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 根据奇偶数，可以知道需要的伴侣是几号
        // 对于一次单独的交换来说，最少促成1对牵手，最多促成2对牵手
        // 要总次数最少，应该尽量多的促成2对牵手
        public int minSwapsCouples(int[] row) {
            int len = row.length;
            int[] indexMap = new int[len]; // 根据值查位置
            for (int i = 0; i < len; i++) {
                indexMap[row[i]] = i;
            }
            int count = 0;
            for (int i = 0; i < len - 1; i += 2) {
                int p1 = row[i];
                int p2 = p1 % 2 == 0 ? p1 + 1 : p1 - 1; // 需要的伴侣p2
                if (row[i + 1] == p2) continue; // 已经在正确的位置上，无需交换
                int p2Index = indexMap[p2]; // p2的位置
                swap(row, indexMap, i + 1, p2Index); // 交换 p2 <=> [i+1]
                count++;
            }
            return count;
        }

        private void swap(int[] row, int[] indexMap, int i, int j) {
            int tmp = row[i];
            row[i] = row[j];
            row[j] = tmp;
            indexMap[row[i]] = i;
            indexMap[row[j]] = j;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}