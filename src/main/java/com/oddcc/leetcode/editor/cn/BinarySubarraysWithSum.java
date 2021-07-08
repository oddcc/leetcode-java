// 930

package com.oddcc.leetcode.editor.cn;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new BinarySubarraysWithSum().new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(solution.numSubarraysWithSum(new int[]{0, 1, 1, 1, 1}, 3));
        System.out.println(solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，滑动窗口
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int len = nums.length;
            int left = 0;
            int right = 0;
            int ans = 0;
            int sum = 0;
            boolean rightInWindow = false;
            while (right < len && left < len) {
                // right不在现有窗口内，才需要计算新的sum值
                if (!rightInWindow && nums[right] == 1) {
                    sum++;
                }
                // 当sum>goal时，继续扩大窗口没有意义
                if (sum > goal) {
                    if (nums[left] == 1) {
                        sum--;
                    }
                    left++;
                    // 因为右边界没动，所以还在窗口内
                    rightInWindow = true;
                }
                // sum达到goal时，所有right开始向右的0，都会算进结果
                else if (sum == goal) {
                    ans++;
                    int tmpI = right + 1;
                    while (tmpI < len && nums[tmpI++] == 0) ans++;
                    // 以left为起点的所有subarray都已经在结果中了，要缩小窗口左端，同时更新sum
                    if (nums[left] == 1) {
                        sum--;
                    }
                    left++;
                    rightInWindow = true;
                }
                else {
                    right++;
                    rightInWindow = false;
                }
                // 确保left不会超过right
                if (right < left) {
                    right = left;
                    rightInWindow = false;
                    sum = 0;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}