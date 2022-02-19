// 502

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ipo {
    public static void main(String[] args) {
        Solution solution = new Ipo().new Solution();
        System.out.println(solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(solution.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，DFS回溯暴搜，超时
    // 思路2，贪心
    // 我们总应该选能做的项目中获取利润最大的项目，这样在选了k次后，总利润才是最大的
    // w只会增加,不会减少，所以可做的项目只会增加，不会减少（除了做过的）
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int len = profits.length;
            int ans = w;
            int[][] projects = new int[len][2];
            for (int i = 0; i < len; i++) {
                projects[i][0] = profits[i];
                projects[i][1] = capital[i];
            }
            // 按capital升序排列
            Arrays.sort(projects, Comparator.comparingInt(p -> p[1]));
            int selectedIndex = 0;
            PriorityQueue<Integer> availableProjects = new PriorityQueue<>((i1, i2) -> i2 - i1);
            for (int i = 0; i < k; i++) {
                // 筛选所有可以做的项目
                while (selectedIndex < len && ans >= projects[selectedIndex][1]) {
                    availableProjects.add(projects[selectedIndex][0]);
                    selectedIndex++;
                }
                if (availableProjects.isEmpty()) {
                    break;
                }
                // 选利润最大的做
                ans += availableProjects.remove();
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}