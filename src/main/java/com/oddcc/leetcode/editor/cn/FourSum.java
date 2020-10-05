//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Notice that the solution set must not contain duplicate quadruplets. 
//
// 
// Example 1: 
// Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2: 
// Input: nums = [], target = 0
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 617 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4) return Collections.emptyList();
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                int p = i;
                int t2 = target - nums[p];
                if (p > 0 && nums[p] == nums[p - 1]) continue; // 去重，当跟上一次相同时，要找的target是一样的，就不用重复算了
                for (int p2 = i + 1; p2 < nums.length - 2; p2++) {
                    int l = p2 + 1;
                    int r = nums.length - 1;
                    if (l >= r) break;
                    if (p2 > i + 1 && nums[p2] == nums[p2 - 1]) continue; // 同上的去重逻辑
                    while (l < r) {
                        int sum = nums[p2] + nums[l] + nums[r];
                        if (sum == t2) {
                            result.add(Arrays.asList(nums[p], nums[p2], nums[l], nums[r]));
                            l = moveLeft(nums, l);
                            r = moveRight(nums, p2, r);
                            continue;
                        }
                        if (sum < t2) {
                            l = moveLeft(nums, l);
                        }
                        else {
                            r = moveRight(nums, p2, r);
                        }
                    }
                }
            }
            return result;
        }

        public int moveLeft(int[] nums, int left) {
            int l = left + 1;
            while (l < nums.length && nums[l] == nums[left]) {
                l++;
            }
            return l;
        }

        public int moveRight(int[] nums, int p, int right) {
            int r = right - 1;
            while (r > p && nums[r] == nums[right]) {
                r--;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}