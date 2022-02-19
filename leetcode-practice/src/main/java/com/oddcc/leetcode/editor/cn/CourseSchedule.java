// 207
package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(solution.canFinish(2, new int[][]{{0, 1}}));
        System.out.println(solution.canFinish(3, new int[][]{{1,0},{1,2},{0,1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 给的前置列表是一副图的表示，上所有的课，就是在前置列表的限制下，访问所有图中的点
        // 是个有向图
        // 访问顺序是如果一个node是无前置的（入度为0），则标记为修过，并按该node的出度把相关的都标记为修过（深度遍历）
        // 所有节点都进行过一次遍历后，如果还有未修过的节点，则表示不能完成
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            boolean[] visited = new boolean[numCourses];
            // 整理输入
            List<Set<int[]>> outEdges = new ArrayList<>(numCourses);
            List<Set<int[]>> inEdges = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                outEdges.add(new HashSet<>());
                inEdges.add(new HashSet<>());
            }
            for (int[] edge : prerequisites) {
                Set<int[]> outs = outEdges.get(edge[1]);
                outs.add(edge);
                Set<int[]> ins = inEdges.get(edge[0]);
                ins.add(edge);
            }
            // 开始遍历
            for (int i = 0; i < numCourses; i++) {
                dfs(i, inEdges, outEdges, visited);
            }

            for (boolean taken : visited) {
                if (!taken) return false;
            }
            return true;
        }

        private void dfs(int i, List<Set<int[]>> inEdges, List<Set<int[]>> outEdges, boolean[] visited) {
            if (visited[i]) return; // 如果i点已访问过，直接返回
            // 如果有前置课程没有上，则返回
            for (int[] in: inEdges.get(i)) {
                if (!visited[in[1]]) return;
            }
            visited[i] = true;
            for (int[] out : outEdges.get(i)) {
                dfs(out[0], inEdges, outEdges, visited);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}