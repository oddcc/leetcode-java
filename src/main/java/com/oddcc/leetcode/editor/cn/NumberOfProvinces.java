// 547

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        System.out.println(solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目都明确画出来是图了，关键是如何构造出图，以及如何判断连通分量
        // 思路1，二维数组构造图，然后进行BFS，判断有几个连通分量
        public int findCircleNum(int[][] isConnected) {
            Map<Integer, List<Integer>> graph = convertToGraph(isConnected);
            int ans = 0;
            int[] nodes = new int[isConnected.length]; // 0表示没访问过，1表示访问过
            for (int i = 0; i < isConnected.length; i++) nodes[i] = 0;
            Queue<Integer> queue = new LinkedList<>();
            while (true) {
                int nextStart = getNextStart(nodes);
                if (nextStart == -1) break;
                queue.add(nextStart);
                while (!queue.isEmpty()) {
                    int node = queue.remove();
                    if (nodes[node] == 1) continue;
                    nodes[node] = 1; // 标为访问过
                    queue.addAll(graph.get(node));
                }
                ans++;
            }
            return ans;
        }

        private int getNextStart(int[] nodes) {
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] == 0) return i;
            }
            return -1;
        }

        private Map<Integer, List<Integer>> convertToGraph(int[][] isConnected) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[i][j] == 1) {
                        List<Integer> ij = graph.get(i);
                        if (ij == null) {
                            ij = new ArrayList<>();
                            ij.add(j);
                            graph.put(i, ij);
                        }
                        else {
                            ij.add(j);
                        }
                        List<Integer> ji = graph.get(j);
                        if (ji == null) {
                            ji = new ArrayList<>();
                            ji.add(i);
                            graph.put(j, ji);
                        }
                        else {
                            ji.add(i);
                        }
                    }
                }
            }
            return graph;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}