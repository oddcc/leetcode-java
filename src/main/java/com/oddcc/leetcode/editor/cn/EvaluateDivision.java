// 399

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ArrayListUtils;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        System.out.println(Arrays.toString(solution.calcEquation(
                ArrayListUtils.arrayToList(new String[][]{{"a", "b"}, {"b", "c"}}),
                new double[]{2.0, 3.0},
                ArrayListUtils.arrayToList(new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}})
        )));
        System.out.println(Arrays.toString(solution.calcEquation(
                ArrayListUtils.arrayToList(new String[][]{{"a", "b"}, {"b", "c"}, {"bc", "cd"}}),
                new double[]{1.5, 2.5, 5.0},
                ArrayListUtils.arrayToList(new String[][]{{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}})
        )));
        System.out.println(Arrays.toString(solution.calcEquation(
                ArrayListUtils.arrayToList(new String[][]{{"a", "b"}}),
                new double[]{0.5},
                ArrayListUtils.arrayToList(new String[][]{{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}})
        )));
        System.out.println(Arrays.toString(solution.calcEquation(
                ArrayListUtils.arrayToList(new String[][]{{"x1", "x2"}, {"x2", "x3"}, {"x3", "x4"}, {"x4", "x5"}}),
                new double[]{3.0, 4.0, 5.0, 6.0},
                ArrayListUtils.arrayToList(new String[][]{{"x1", "x5"}, {"x5", "x2"}, {"x2", "x4"}, {"x2", "x2"}, {"x2", "x9"}, {"x9", "x9"}})
        )));
        System.out.println(Arrays.toString(solution.calcEquation(
                ArrayListUtils.arrayToList(new String[][]{{"a", "b"}, {"b", "c"}, {"a", "c"}, {"d", "e"}}),
                new double[]{2.0, 3.0, 6.0, 1.0},
                ArrayListUtils.arrayToList(new String[][]{{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}, {"a", "d"}})
        )));
        System.out.println(Arrays.toString(solution.calcEquation(
                ArrayListUtils.arrayToList(new String[][]{{"a", "e"}, {"b", "e"}}),
                new double[]{4.0, 3.0},
                ArrayListUtils.arrayToList(new String[][]{{"a","b"},{"e","e"},{"x","x"}})
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，加权有向图？哈希表+哈希表表示加权有向图，搜索用BFS
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> graph = getGraph(equations, values);
            List<Double> ansList = new ArrayList<>();
            for (List<String> query : queries) {
                String a = query.get(0);
                String b = query.get(1);
                ansList.add(shortestPathValue(a, b, graph));
            }
            double[] ans = new double[ansList.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }

        private class Pair {
            private String node;
            private Double value;

            public Pair(String node, Double value) {
                this.node = node;
                this.value = value;
            }
        }

        // 在图中通过BFS的方式，计算起点到终点的权重
        // 结果是起始到结束点的所有权重的乘积，如果起点终点相同，结果为1，如果有任意点不存在，结果为-1
        // 如果找不到对应的通路，也返回-1
        private Double shortestPathValue(String start, String end, Map<String, Map<String, Double>> graph) {
            if (!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;
            if (start.equals(end)) return 1.0;
            Set<String> visited = new HashSet<>();
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(start, 1.0));
            while (!queue.isEmpty()) {
                Pair n = queue.remove();
                visited.add(n.node);
                for (String next : graph.get(n.node).keySet()) {
                    if (visited.contains(next)) continue;
                    if (next.equals(end)) return graph.get(n.node).get(next) * n.value;
                    queue.add(new Pair(next, graph.get(n.node).get(next) * n.value));
                }
            }
            return -1.0;
        }

        private Map<String, Map<String, Double>> getGraph(List<List<String>> equations, double[] values) {
            Map<String, Map<String, Double>> graph = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                List<String> equation = equations.get(i);
                double value = values[i];
                String a = equation.get(0);
                String b = equation.get(1);
                Map<String, Double> edgeAB = graph.get(a);
                if (edgeAB == null) {
                    edgeAB = new HashMap<>();
                    edgeAB.put(b, value);
                    graph.put(a, edgeAB);
                }
                else {
                    edgeAB.put(b, value);
                }
                Map<String, Double> edgeBA = graph.get(b);
                if (edgeBA == null) {
                    edgeBA = new HashMap<>();
                    edgeBA.put(a, 1 / value);
                    graph.put(b, edgeBA);
                }
                else {
                    edgeBA.put(a, 1 / value);
                }
            }
            return graph;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}