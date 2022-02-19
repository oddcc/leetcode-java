// 135

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
        System.out.println(solution.candy(new int[]{1, 0, 2}));
        System.out.println(solution.candy(new int[]{1, 2, 2}));
        System.out.println(solution.candy(new int[]{3, 2, 1}));
        System.out.println(solution.candy(new int[]{3, 2, 1, 0, 2, 1, 1, 0}));
        System.out.println(solution.candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(solution.candy(new int[]{1, 2, 3, 1, 0}));
        System.out.println(solution.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，一个一个处理
        public int candy(int[] ratings) {
            int len = ratings.length;
            int[] candies = new int[len];
            candies[0] = 1;
            for (int i = 1; i < len; i++) {
                // 当新加入的比最后一个小，则要把之前符合条件的都+1
                if (ratings[i] < ratings[i - 1]) {
                    candies[i] = 1;
                    // 前一个rank高，但糖没有更多，才需要增加
                    if (candies[i] >= candies[i - 1]) increment(candies, ratings, i - 1);
                }
                // 当新加入的跟最后一个相同，则新加入的值是1
                else if (ratings[i] == ratings[i - 1]) {
                    candies[i] = 1;
                }
                // 当新加入的比最后一个大，则新加入的值是最后一个值+1
                else {
                    candies[i] = candies[i - 1] + 1;
                }
            }
            System.out.println(Arrays.toString(candies));
            return Arrays.stream(candies).sum();
        }

        // 从i开始往前，把符合条件的+1
        private void increment(int[] candies, int[] ratings, int i) {
            // 先把当前位置的+1，然后看之前的
            candies[i]++;
            i--;
            while (i >= 0) {
                // 当i的rating大于i+1，但糖没有比i+1多时，candies[i] ++
                if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i]++;
                    i--;
                } else {
                    break;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}