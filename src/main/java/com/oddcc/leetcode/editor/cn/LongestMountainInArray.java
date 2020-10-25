package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestMountainInArray {
    public static void main(String[] args) {
        Solution solution = new LongestMountainInArray().new Solution();
//        System.out.println(solution.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
//        System.out.println(solution.longestMountain(new int[]{2, 5, 2}));
//        System.out.println(solution.longestMountain(new int[]{2, 2, 2}));
        System.out.println(solution.longestMountain(new int[]{875, 884, 239, 731, 723, 685}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 从头开始遍历字符串，当遇到一个新的字符时，实际会有4种状态；可以用状态机来解
        private final Map<String, List<String>> stateMachine = new HashMap<>() {{
            put("init", Arrays.asList("init", "up", "init"));
            put("up", Arrays.asList("init", "up", "down"));
            put("down", Arrays.asList("success", "success", "down"));
            put("success", Arrays.asList("init", "up", "init"));
        }};

        public int longestMountain(int[] A) {
            String state = "init";
            Integer tmp = null;
            int len = 0;
            int maxLen = 0;
            for (int i : A) {
                if (tmp == null) {
                    tmp = i;
                    len++;
                }
                else {
                    if (tmp == i) {
                        state = stateMachine.get(state).get(0);
                    }
                    else if (tmp < i) {
                        state = stateMachine.get(state).get(1);
                    }
                    else {
                        state = stateMachine.get(state).get(2);
                    }
                    if (state.equals("success") && len >= 3) {
                        maxLen = Math.max(maxLen, len);
                        len = 1;
                        tmp = i;
                        continue;
                    }
                    if (state.equals("up") || state.equals("down")) {
                        len++;
                        tmp = i;
                        continue;
                    }
                    if (state.equals("init")) {
                        len = 1;
                        tmp = i;
                    }
                }
            }
            if (state.equals("down") && len >= 3) {
                maxLen = Math.max(maxLen, len);
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}