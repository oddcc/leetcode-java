// 401

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        System.out.println(solution.readBinaryWatch(1));
        System.out.println(solution.readBinaryWatch(2));
        System.out.println(solution.readBinaryWatch(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，回溯法，遍历所有答案
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            // 长度为10的数组，表示每个灯的状态
            List<int[]> options = new ArrayList<>();
            backtracing(turnedOn, 0, 0, new int[10], options);
            // 0~3是小时，转成10进制，范围是0~11，4~9是分钟，转成10进制，范围是0~59
            return convert(options);
        }

        private List<String> convert(List<int[]> options) {
            return options.stream()
                    .map(in -> {
                        StringBuilder h = new StringBuilder();
                        StringBuilder m = new StringBuilder();
                        for (int i = 0; i < in.length; i++) {
                            if (i <= 3) h.append(in[i]);
                            else m.append(in[i]);
                        }
                        int hour = Integer.valueOf(h.toString(), 2);
                        int min = Integer.valueOf(m.toString(), 2);
                        if (hour > 11) return "";
                        if (min > 59) return "";
                        return String.format("%d:%02d", hour, min);
                    })
                    .filter(in -> !in.isEmpty())
                    .collect(Collectors.toList());
        }

        /**
         *
         * @param total 总灯数
         * @param count 当前灯数
         * @param cur 当前位置
         * @param leds
         * @param options
         */
        private void backtracing(int total, int count, int cur, int[] leds, List<int[]> options) {
            if (count == total) {
                options.add(Arrays.copyOf(leds, leds.length));
                return;
            }
            if (cur >= leds.length || cur < 0) return;
            leds[cur] = 1;
            backtracing(total, count + 1, cur + 1, leds, options);
            leds[cur] = 0;
            backtracing(total, count, cur + 1, leds, options);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}