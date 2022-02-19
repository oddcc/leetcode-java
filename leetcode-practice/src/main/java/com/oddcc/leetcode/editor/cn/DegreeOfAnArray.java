// 697

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(solution.findShortestSubArray(new int[]{2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2}));
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            // 找到出现次数最多的数字是什么，可能有多个
            Map<Integer, Integer> countMap = new HashMap<>();
            PriorityQueue<Integer> maxCountHeap = new PriorityQueue<>((n1, n2) -> countMap.get(n2) - countMap.get(n1));
            for (int i : nums) {
                int count = countMap.getOrDefault(i, 0) + 1;
                countMap.put(i, count);
                maxCountHeap.remove(i);
                maxCountHeap.add(i);
            }
            Integer preCount = null;
            List<Integer> options = new ArrayList<>();
            while (!maxCountHeap.isEmpty()) {
                int maxNumber = maxCountHeap.remove();
                if (preCount == null) {
                    options.add(maxNumber);
                    preCount = countMap.get(maxNumber);
                }
                else {
                    if (countMap.get(maxNumber) < preCount) break;
                    options.add(maxNumber);
                }
            }

            int ans = nums.length;
            for (int maxNumber : options) {
                // 在数组中找到maxNumber最左和最右的位置
                int left = 0;
                while (left < nums.length && nums[left] != maxNumber) {
                    left++;
                }
                int right = nums.length - 1;
                while (right >= 0 && nums[right] != maxNumber) {
                    right--;
                }
                ans = Math.min(ans, right - left + 1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}