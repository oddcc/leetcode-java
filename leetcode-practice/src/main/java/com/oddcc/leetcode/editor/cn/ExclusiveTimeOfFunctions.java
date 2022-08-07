// 636

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        Solution solution = new ExclusiveTimeOfFunctions().new Solution();
        System.out.println(Arrays.toString(solution.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
        System.out.println(Arrays.toString(solution.exclusiveTime(1, Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"))));
        System.out.println(Arrays.toString(solution.exclusiveTime(2, Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final String SPLITTER = ":";
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] ans = new int[n];
            Arrays.fill(ans, 0);

            Deque<String> callStack = new LinkedList<>();
            for (String log : logs) {
                if (callStack.isEmpty()) {
                    callStack.push(log);
                    continue;
                }
                String topLog = callStack.peek();
                if (getId(topLog) == getId(log) && "start".equals(getStatus(topLog)) && "end".equals(getStatus(log))) {
                    int callTime = getTime(log) - getTime(topLog) + 1;
                    ans[getId(log)] += callTime;
                    callStack.pop();
                    String outerCallLog = callStack.peek();
                    if (outerCallLog == null) {
                        continue;
                    }
                    ans[getId(outerCallLog)] -= callTime;
                } else {
                    callStack.push(log);
                }
            }

            return ans;
        }

        private int getTime(String log) {
            return Integer.parseInt(log.split(SPLITTER)[2]);
        }

        private String getStatus(String log) {
            return log.split(SPLITTER)[1];
        }

        private int getId(String log) {
            return Integer.parseInt(log.split(SPLITTER)[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}