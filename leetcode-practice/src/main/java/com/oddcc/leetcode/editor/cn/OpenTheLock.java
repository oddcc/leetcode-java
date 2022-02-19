// 752

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
        System.out.println(solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(solution.openLock(new String[]{"8888"}, "0009"));
        System.out.println(solution.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，bfs，因为题目要求最小旋转次数，优先考虑bfs
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
            if (deadSet.contains(target)) return -1;
            Deque<String> queue = new LinkedList<>();
            queue.add("0000");
            Set<String> seen = new HashSet<>();
            int count = 0;
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    String cur = queue.removeLast();
                    if (seen.contains(cur)) continue;
                    seen.add(cur);
                    if (cur.equals(target)) return count;
                    if (deadSet.contains(cur)) continue;
                    queue.addFirst(spin(cur, 0, 0));
                    queue.addFirst(spin(cur, 0, 1));
                    queue.addFirst(spin(cur, 1, 0));
                    queue.addFirst(spin(cur, 1, 1));
                    queue.addFirst(spin(cur, 2, 0));
                    queue.addFirst(spin(cur, 2, 1));
                    queue.addFirst(spin(cur, 3, 0));
                    queue.addFirst(spin(cur, 3, 1));
                }
                count++;
            }
            return -1;
        }

        // direction == 1往大转
        // direction == 0往小转
        private String spin(String cur, int i, int direction) {
            int[] arr = new int[4];
            for (int x = 0; x < cur.length(); x++) {
                arr[x] = cur.charAt(x) - '0';
            }
            if (direction == 1) {
                if (arr[i] == 9) arr[i] = 0;
                else arr[i]++;
            }
            else {
                if (arr[i] == 0) arr[i] = 9;
                else arr[i]--;
            }
            StringBuilder sb = new StringBuilder();
            for (int x : arr) sb.append(x);
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}