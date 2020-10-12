package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
//        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8)));
//        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6)));
//        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{0,0,2,3,4,4,4,5}, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            int low = searchMostLeft(nums, 0, nums.length - 1, target);
            if (low == -1) return new int[]{-1, -1};
            int high = searchMostRight(nums, 0, nums.length - 1, target);
            return new int[]{low, high};
        }

        private int searchMostRight(int[] nums, int low, int high, int target) {
            if (low >= high) {
                if (nums[low] == target) {
                    if (valid(nums, low + 1) && nums[low + 1] == target) {
                        return low + 1;
                    }
                    else {
                        return low;
                    }
                }
                else if (nums[low] > target) {
                    if (valid(nums, low - 1) && nums[low - 1] == target) {
                        return low - 1;
                    }
                    else {
                        return -1;
                    }
                }
                else {
                    return -1;
                }
            }
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                if (valid(nums, mid + 1)) {
                    if (nums[mid + 1] > target) {
                        return mid;
                    }
                    else {
                        return searchMostRight(nums, mid + 1, high, target);
                    }
                }
                else {
                    return mid;
                }
            }
            else if (nums[mid] > target) {
                if (valid(nums, mid - 1)) {
                    return searchMostRight(nums, low, mid - 1, target);
                }
                else {
                    return -1;
                }
            }
            else {
                return searchMostRight(nums, mid + 1, high, target);
            }
        }

        private int searchMostLeft(int[] nums, int low, int high, int target) {
            if (low >= high) {
                if (nums[low] == target) {
                    if (valid(nums, low - 1) && nums[low - 1] == target) {
                        return low - 1;
                    }
                    else {
                        return low;
                    }
                }
                else if (nums[low] > target) {
                    return -1;
                }
                else {
                    if (valid(nums, low + 1) && nums[low + 1] == target) {
                        return low + 1;
                    }
                    else {
                        return -1;
                    }
                }
            }
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                if (valid(nums, mid - 1)) {
                    if (nums[mid - 1] < target) {
                        return mid;
                    }
                    else {
                        return searchMostLeft(nums, low, mid - 1, target);
                    }
                }
                else {
                    return mid;
                }
            }
            else if (nums[mid] > target) {
                if (valid(nums, mid - 1)) {
                    return searchMostLeft(nums, low, mid - 1, target);
                }
                else {
                    return -1;
                }
            }
            else {
                if (valid(nums, mid + 1) && nums[mid + 1] == target) {
                    return mid + 1;
                }
                else {
                    return searchMostLeft(nums, mid + 1, high, target);
                }
            }
        }

        private boolean valid(int[] nums, int i) {
            return i >= 0 && i < nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}