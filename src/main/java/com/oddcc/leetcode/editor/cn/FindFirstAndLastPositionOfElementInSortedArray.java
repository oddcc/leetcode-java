package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
//        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8)));
//        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6)));
//        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{0, 0, 2, 3, 4, 4, 4, 5}, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 二分查找的思路比较简单，就是通过二分查找找target，找到时，判断是不是边缘的元素，不是的话还要继续查找，要注意两个准则
        // 1. 每次递归都要缩小问题的范围，如果不注意这一点，可能会产生无限循环
        // 2. 每次递归的时候，不能排除潜在的正确答案，如果不注意这一点，会导致结果错误或找不到结果
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            // 先找左边缘
            int low = searchMostLeft(nums, 0, nums.length - 1, target);
            // 因为函数还是二分查找，如果返回-1，说明没有target元素，就不用再继续找了
            if (low == -1) return new int[]{-1, -1};
            // 再找又边缘
            int high = searchMostRight(nums, 0, nums.length - 1, target);
            return new int[]{low, high};
        }

        // 参考 searchMostLeft 的思路即可
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
                return searchMostRight(nums, low, mid - 1, target);
            }
            else {
                return searchMostRight(nums, mid + 1, high, target);
            }
        }

        private int searchMostLeft(int[] nums, int low, int high, int target) {
            // 基准条件，表示只包含一个元素
            if (low >= high) {
                // 如果就是target，如果左边还有元素，且左边元素也是target，则说明low不是答案（数组有序，左边的不可能大于target）
                if (nums[low] == target) {
                    if (valid(nums, low - 1) && nums[low - 1] == target) {
                        return low - 1;
                    }
                    else {
                        return low;
                    }
                }
                // 已经到最后了，没找到，返回-1
                else if (nums[low] > target) {
                    return -1;
                }
                // 这里是nums[low] < target的情况；看右边元素，如果存在且为target，则右边就是答案，否则说明没有答案
                // 也可以直接向右边寻找
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
            // 如果mid元素跟target相等
            // 看看左边是否存在，如果存在，看看左边元素是否小于target，如果小于，mid就是答案；
            // 如果不小于，那只能是等于，需要再继续查找（数组有序，左边不可能大于mid元素）
            // 如果不存在，那么mid元素就是最左侧的元素
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
                return searchMostLeft(nums, low, mid - 1, target);
            }
            // 这里是 nums[mid] < target 的情况
            else {
                // 如果右边的元素正好等于target，则右边元素就是答案
                if (valid(nums, mid + 1) && nums[mid + 1] == target) {
                    return mid + 1;
                }
                // 否则继续向右边寻找
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