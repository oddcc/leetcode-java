// 1122

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，哈希表+自定义排序
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < arr2.length; i++) {
                cache.put(arr2[i], i);
            }
            List<Integer> arr = new ArrayList<>();
            for (int i : arr1) {
                arr.add(i);
            }
            arr.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    Integer index1 = cache.get(o1);
                    Integer index2 = cache.get(o2);
                    if (index1 == null && index2 == null) return o1 - o2;
                    if (index1 == null) return 1;
                    if (index2 == null) return -1;
                    return index1 - index2;
                }
            });
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = arr.get(i);
            }
            return arr1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}