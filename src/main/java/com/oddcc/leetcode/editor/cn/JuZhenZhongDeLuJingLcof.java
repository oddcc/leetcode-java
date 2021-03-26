// 剑指 Offer 12

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        System.out.println(solution.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(solution.exist(new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        }, "abcd"));
        System.out.println(solution.exist(new char[][]{
                {'F','Y','C','E','N','R','D'},
                {'K','L','N','F','I','N','U'},
                {'A','A','A','R','A','H','R'},
                {'N','D','K','L','P','N','E'},
                {'A','L','A','N','S','A','P'},
                {'O','O','G','O','T','P','N'},
                {'H','P','O','L','A','N','O'}
        }, "poland"));
        System.out.println(solution.exist(new char[][]{
                {'b','a','a','b','a','b'},
                {'a','b','a','a','a','a'},
                {'a','b','a','a','a','b'},
                {'a','b','a','b','b','a'},
                {'a','a','b','b','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','b','a','a','b'}
        }, "aabbbbabbaababaaaabababbaaba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，DFS+回溯，不需要考虑部分匹配的情况，因为是遍历了每个点为起点的情况，如果存在匹配的话，则一定能找到
        // 同理，不需要考虑当前不匹配，但后续可能匹配的情况（也算是一种部分匹配），从而实现剪枝
        private boolean found = false;

        public boolean exist(char[][] board, String word) {
            found = false;
            int m = board.length;
            int n = board[0].length;
            char[] chars = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    boolean[][] visited = new boolean[m][n];
                    dfs(board, visited, i, j, new ArrayList<>(), chars);
                }
            }
            return found;
        }

        /**
         *  @param board
         * @param visited
         * @param x 起点x
         * @param y 起点y
         * @param path
         * @param chars
         */
        private void dfs(char[][] board, boolean[][] visited, int x, int y, ArrayList<Character> path, char[] chars) {
            if (found) return; // 如果已经找到了，就返回
            if (!valid(x, y, visited)) return; // 越界或者元素已访问过
            if (path.size() > chars.length) return; // 超长了
            if (chars[path.size()] != board[x][y]) return; // 当前元素不匹配
            visited[x][y] = true;
            path.add(board[x][y]);
            if (equals(path, chars)) {
                found = true;
                return;
            }
            // 上
            if (valid(x - 1, y, visited)) dfs(board, visited, x - 1, y, path, chars);
            // 左
            if (valid(x, y - 1, visited)) dfs(board, visited, x, y - 1, path, chars);
            // 下
            if (valid(x + 1, y, visited)) dfs(board, visited, x + 1, y, path, chars);
            // 右
            if (valid(x, y + 1, visited)) dfs(board, visited, x, y + 1, path, chars);
            path.remove(path.size() - 1);
            visited[x][y] = false;
        }

        private boolean equals(ArrayList<Character> path, char[] chars) {
            if (path.size() < chars.length) return false;
            for (int i = 0; i < chars.length; i++) {
                if (path.get(i) != chars[i]) return false;
            }
            return true;
        }

        private boolean valid(int x, int y, boolean[][] visited) {
            int m = visited.length;
            int n = visited[0].length;
            return x >= 0 && x < m && y >= 0 && y < n && !visited[x][y];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}