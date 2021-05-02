// 554

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public static void main(String[] args) {
        Solution solution = new BrickWall().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，哈希表，把经过砖块的长度x看作间隙的位置，那么通过最少的砖块，就是通过最多的间隙
    // 我们可以统计每个间隙的数量，求得答案
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            int n = wall.size();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0, sum = 0; i < n; i++, sum = 0) {
                for (int cur : wall.get(i)) {
                    sum += cur;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
                map.remove(sum); // 不能从两边穿过，需要 remove 掉最后一个
            }
            int ans = n;
            for (int u : map.keySet()) {
                int cnt = map.get(u);
                ans = Math.min(ans, n - cnt);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}