// 12

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        System.out.println(solution.intToRoman(1));
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，转换成n的数字的和，n个数字要求是10^x的倍数，如1994 -> 1000 + 900 + 90 + 4；然后利用罗马数字的转换规则，分别转换后拼接
        public String intToRoman(int num) {
            List<Integer> numList = new ArrayList<>(); // 低位存低位
            int step = 10;
            while (num > 0) {
                int remain = num % step;
                num = num - remain;
                step *= 10;
                numList.add(remain);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = numList.size() - 1; i >= 0; i--) {
                sb.append(convert(numList.get(i)));
            }
            return sb.toString();
        }

        private StringBuilder convert(Integer integer) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < range.length; i++) {
                if (integer >= range[i][0] && integer <= range[i][1]) {
                    int t = i / 2;
                    // 说明是1000
                    if (t == 3) {
                        sb.append(String.valueOf(roman[t][0]).repeat(integer / range[i][0]));
                        break;
                    }
                    // 说明是1～3
                    if (i % 2 == 0) {
                        sb.append(String.valueOf(roman[t][0]).repeat(integer / range[i][0]));
                    }
                    // 说明是4～9
                    else {
                        // == 9
                        if (integer == (range[i][0] / 4) * 9) {
                            sb.append(roman[t][0]).append(roman[t][2]);
                        }
                        // > 5
                        else if (integer > (range[i][0] / 4) * 5) {
                            sb.append(roman[t][1]);
                            sb.append(String.valueOf(roman[t][0]).repeat(Math.max(0, (integer - (range[i][0] / 4) * 5) / (range[i][0] / 4))));
                        }
                        // == 5
                        else if (integer == (range[i][0] / 4) * 5) {
                            sb.append(roman[t][1]);
                        }
                        // < 5
                        else {
                            sb.append(roman[t][0]).append(roman[t][1]);
                        }
                    }
                }
            }
            return sb;
        }

        int[][] range = new int[][]{
                {1, 3}, // 0
                {4, 9}, // 1
                {10, 30}, // 2
                {40, 90}, // 3
                {100, 300}, // 4
                {400, 900}, // 5
                {1000, Integer.MAX_VALUE}, // 6
        };
        String[][] roman = new String[][]{
                {"I", "V", "X"}, // 0
                {"X", "L", "C"}, // 1
                {"C", "D", "M"}, // 2
                {"M", "", ""}, // 3
        };
    }
    //leetcode submit region end(Prohibit modification and deletion)

}