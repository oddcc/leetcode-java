// 599

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution solution = new MinimumIndexSumOfTwoLists().new Solution();
        System.out.println(Arrays.toString(solution.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                indexMap.put(list1[i], i);
            }
            Integer min = Integer.MAX_VALUE;
            Set<String> ansSet = new HashSet<>();
            for (int i = 0; i < list2.length; i++) {
                String s = list2[i];
                if (indexMap.get(s) != null) {
                    if (min > indexMap.get(s) + i) {
                        min = indexMap.get(s) + i;
                        ansSet = new HashSet<>();
                        ansSet.add(s);
                    } else if (min == indexMap.get(s) + i){
                        ansSet.add(s);
                    }
                }
            }
            return ansSet.toArray(new String[0]);
         }
    }
//leetcode submit region end(Prohibit modification and deletion)

}