// 1207

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new UniqueNumberOfOccurrences().new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，哈希表，先遍历一次，建立值-出现次数的哈希表；
        // 再遍历这个哈希表，并把遇到的值放到另一个哈希表中，如果在遍历过程中发现key已存在，返回false，否则返回true
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i: arr) {
                int count = countMap.getOrDefault(i, 0);
                countMap.put(i, count + 1);
            }
            Set<Integer> s = new HashSet<>();
            for (Integer i: countMap.keySet()) {
                int value = countMap.get(i);
                if (s.contains(value)) return false;
                s.add(value);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}