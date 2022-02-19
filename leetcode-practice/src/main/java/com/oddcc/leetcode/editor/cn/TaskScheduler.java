// 621

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new TaskScheduler().new Solution();
        System.out.println(solution.leastInterval(new char[]{'a', 'a', 'a', 'b', 'b', 'b'}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历+计数，从最多的开始安排，直到所有任务都安排完毕
        public int leastInterval(char[] tasks, int n) {
            int ans = 0;
            // 统计任务出现次数
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : tasks) {
                int count = charCount.getOrDefault(c, 0);
                charCount.put(c, count + 1);
            }
            // 根据任务出现次数放入最大堆中
            PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> charCount.get(c2) - charCount.get(c1));
            maxHeap.addAll(charCount.keySet());
            // 知道要分配多少个任务，每次分配时最多分配n个任务，如果不到n个可选任务就选完了，就要加入idle
            int total = tasks.length;
            while (total > 0) {
                List<Character> used = new ArrayList<>();
                // 冷却是n，则加上idle的话，一轮要分配n+1次，如n=2时 a, b, c, a，即在a之后经过2次分配，才能再分配a
                for (int j = 0; j < n + 1 && total > 0; j++) {
                    if (!maxHeap.isEmpty()) {
                        char c = maxHeap.poll();
                        used.add(c);
                        charCount.put(c, charCount.get(c) - 1);
                        total--;
                    }
                    ans++;
                }
                // 根据新的次数重新入堆，方便下次继续选择
                for (char c : used) {
                    if (charCount.get(c) > 0) maxHeap.add(c);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}