// 1202

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ArrayListUtils;

import java.util.*;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        Solution solution = new SmallestStringWithSwaps().new Solution();
        System.out.println(solution.smallestStringWithSwaps("dcab", ArrayListUtils.arrayToList(new Integer[][]{{0, 3}, {1, 2}})));
        System.out.println(solution.smallestStringWithSwaps("dcab", ArrayListUtils.arrayToList(new Integer[][]{{0, 3}, {1, 2}, {0, 2}})));
        System.out.println(solution.smallestStringWithSwaps("cba", ArrayListUtils.arrayToList(new Integer[][]{{0, 1}, {1, 2}})));
        System.out.println(solution.smallestStringWithSwaps("udyyek", ArrayListUtils.arrayToList(new Integer[][]{{3, 3}, {3, 0}, {5, 1}, {3, 1}, {3, 4}, {3, 5}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 似乎可以发现规律，每个pair代表的是两个位置的连接关系，如果所有的位置都有连接（用图表示就是都是连通的）
        // 那么最小的字符串就是处于各连通分量中的字符，按字典序升序排列的结果
        // 要确定的是，只要通过pair关系进行了连接，就一定可以通过不限次数的交换来获得任意想要的排序吗？
        // 思路1，遍历字符串，建立连通图，要记录每个位置属于哪个连通分量；按位置进行填充，每次取该连通分量内最小的元素
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            List<List<Integer>> graph = getGraph(s, pairs);
            int[] existence = new int[s.length()]; // value是连通分量号，用于查询位置属于哪个连通分量
            // 通过使用优先队列，使连通分量内的字符有序
            Map<Integer, Queue<Character>> graph2 = new HashMap<>(); // key是连通分量号，value是该连通分量中的字符
            // 建立图
            int[] visited = new int[s.length()]; // 0 -> 未访问，1 -> 已访问
            while (true) {
                int start = getId(visited); // 找到的第一个元素索引当作连通分量编号
                if (start == -1) break;
                Queue<Integer> queue = new LinkedList<>();
                Queue<Character> priorityQueue = new PriorityQueue<>(Character::compareTo);
                queue.add(start);
                while (!queue.isEmpty()) {
                    int i = queue.remove();
                    if (visited[i] == 1) continue;
                    visited[i] = 1;
                    existence[i] = start;
                    priorityQueue.add(s.charAt(i));
                    for (int node : graph.get(i)) {
                        if (visited[node] == 0) queue.add(node);
                    }
                }
                graph2.put(start, priorityQueue);
            }
            // 输出结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(graph2.get(existence[i]).remove());
            }
            return sb.toString();
        }

        private int getId(int[] visited) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 0) return i;
            }
            return -1;
        }

        private List<List<Integer>> getGraph(String s, List<List<Integer>> pairs) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) ans.add(new ArrayList<>());
            for (List<Integer> pair : pairs) {
                int index1 = pair.get(0);
                int index2 = pair.get(1);
                if (index1 == index2) continue;
                ans.get(index1).add(index2);
                ans.get(index2).add(index1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}