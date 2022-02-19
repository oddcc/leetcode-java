// 684

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new RedundantConnection().new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{20, 24}, {3, 17}, {17, 20}, {8, 15}, {14, 17}, {6, 17}, {15, 23}, {6, 8}, {15, 19}, {16, 22}, {7, 9}, {8, 22}, {2, 4}, {4, 11}, {22, 25}, {6, 24}, {13, 19}, {15, 18}, {1, 9}, {4, 9}, {4, 19}, {5, 10}, {4, 21}, {4, 12}, {5, 6}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，从后向前一个一个试，删掉边之后，如果图变为无环图则找到答案
        // 思路2，暴力法，如果发现删掉某条边后，图的连通分量数没增加，说明找到答案，跟思路1差不多，代码不写了
        public int[] findRedundantConnection(int[][] edges) {
            List<Set<Integer>> graph = getGraph(edges);
            int[] ans = null;
            for (int i = edges.length - 1; i >= 0; i--) {
                int[] edge = edges[i];
                removeEdge(graph, edge);
                if (!hasCycle(graph)) {
                    ans = edge;
                    break;
                }
                addEdge(graph, edge);
            }
            return ans;
        }

        private boolean hasCycle(List<Set<Integer>> graph) {
            Queue<int[]> queue = new LinkedList<>(); // node, pre
            int[] visited = new int[graph.size()];
            while (true) {
                int start = getNextStart(visited);
                if (start == -1) break; // 结点全部访问过了，结束
                queue.add(new int[]{start, -1});
                while (!queue.isEmpty()) {
                    int[] node = queue.remove();
                    if (visited[node[0]] == 1) continue;
                    visited[node[0]] = 1;
                    for (int next : graph.get(node[0])) {
                        // 如果发现相邻的节点已访问过，且不是来的时候的节点，说明有其他路径可以访问到该节点，那么说明图中存在环
                        if (visited[next] == 1) {
                            if (next != node[1]) return true;
                            continue;
                        }
                        queue.add(new int[]{next, node[0]});
                    }
                }
            }
            return false;
        }

        private int getNextStart(int[] visited) {
            int start = -1;
            for (int i = 1; i < visited.length; i++) {
                if (visited[i] == 1) continue;
                start = i;
                break;
            }
            return start;
        }

        private void addEdge(List<Set<Integer>> graph, int[] edge) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        private void removeEdge(List<Set<Integer>> graph, int[] edge) {
            graph.get(edge[0]).remove(edge[1]);
            graph.get(edge[1]).remove(edge[0]);
        }

        private List<Set<Integer>> getGraph(int[][] edges) {
            List<Set<Integer>> g = new ArrayList<>();
            for (int i = 0; i < edges.length + 1; i++) g.add(new HashSet<>());
            for (int[] edge : edges) {
                addEdge(g, edge);
            }
            return g;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}