// 959

package com.oddcc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class RegionsCutBySlashes {
    public static void main(String[] args) {
        Solution solution = new RegionsCutBySlashes().new Solution();
        System.out.println(solution.regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(solution.regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(solution.regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(solution.regionsBySlashes(new String[]{"/\\", "\\/"}));
        System.out.println(solution.regionsBySlashes(new String[]{"//", "/ "}));
        System.out.println(solution.regionsBySlashes(new String[]{"//\\\\////", "//\\\\/\\//", "\\/ /\\\\/\\", "///\\\\\\\\ ", "//  / \\\\", "\\/\\/ //\\", " // \\ \\\\", "/\\\\/\\\\\\/"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，1*1的grid转化成3*3的矩阵，划线的地方标记为1，其余标记为0，问题转化为求有多少个岛
        // 在矩阵中求有多少个岛的问题可以用染色+dfs/bfs来解决
        // 思路2，利用并查集，把每个1*1的grid看成4个三角形，如果三角形相连，就可以视为在一个连通分量中
        // 问题可以转化为，最后图中有几个连通分量
        public int regionsBySlashes(String[] grid) {
            int len = grid.length;
            int n = 4 * len * len; // 用于表示所有三角形

            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    char c = grid[i].charAt(j);
                    int zi = 4 * (i * len + j); // 一个grid中第一个三角形的位置
                    if (c == ' ') {
                        unionFind.union(zi, zi + 1);
                        unionFind.union(zi + 1, zi + 2);
                        unionFind.union(zi + 2, zi + 3);
                    }
                    if (c == '/') {
                        unionFind.union(zi, zi + 3);
                        unionFind.union(zi + 1, zi + 2);
                    }
                    if (c == '\\') {
                        unionFind.union(zi, zi + 1);
                        unionFind.union(zi + 2, zi + 3);
                    }
                    // 观察可知，如果gridA右边还有另一个gridB，则A的右边总是跟B的左边相连
                    // 同理，下边总是跟下方grid的上边相连
                    if (j < len - 1) {
                        unionFind.union(zi + 1, 4 * (i * len + j + 1) + 3);
                    }
                    if (i < len - 1) {
                        unionFind.union(zi + 2, 4 * ((i + 1) * len + j));
                    }
                }
            }

            return unionFind.getCount();
        }

        private class UnionFind {
            private int[] parent;
            private int count;

            public UnionFind(int count) {
                this.count = count;
                int[] parent = new int[count];
                for (int i = 0; i < count; i++) parent[i] = i;
                this.parent = parent;
            }

            public int getCount() {
                return count;
            }

            public int find(int x) {
                while (x != parent[x]) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public void union(int x, int y) {
                // System.out.println("union " + x + ' ' + y );
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) return;
                if (rootX > rootY) {
                    parent[rootX] = rootY;
                }
                else {
                    parent[rootY] = rootX;
                }
                count--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}