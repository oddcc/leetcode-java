// 978

package com.oddcc.leetcode.editor.cn;

public class LongestTurbulentSubarray {
    public static void main(String[] args) {
        Solution solution = new LongestTurbulentSubarray().new Solution();
        System.out.println(solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(solution.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(solution.maxTurbulenceSize(new int[]{100}));
        System.out.println(solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 9, 1, 9}));
        System.out.println(solution.maxTurbulenceSize(new int[]{1, 1, 1, 1, 1,}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，滑动窗口，每次尝试扩展右边界，当发现不符合时，缩小左边界
        // 不同的是，如果arr[right] == arr[right - 1]的话，则left应该直接设置到right的位置
        // 如果不是的话，则left应该设置到right - 1的位置，并且根据新的大小关系向后遍历，否则可能错过答案
        public int maxTurbulenceSize(int[] arr) {
            int ans = 0;
            int left = 0;
            int right = 0;
            int len = arr.length;
            int status = 0; // 0-待定，1-要升，2-要降
            // 把arr[right]视为新加入的元素
            while (right < len) {
                // 新加入的元素跟之前元素的关系不确定
                if (status == 0) {
                    if (right - 1 >= 0) {
                        // 如果新加入的元素比之前的大，下次要降序
                        if (arr[right] > arr[right - 1]) {
                            status = 2;
                            right++;
                        }
                        // 如果新加入的元素比之前的小，下次要升序
                        else if (arr[right] < arr[right - 1]) {
                            status = 1;
                            right++;
                        }
                        // 相等的话，下次还是不知道要找什么
                        else {
                            left = right;
                            right++;
                        }
                    }
                    // 这里是第一次运行的时候，即right==0时
                    else {
                        ans = Math.max(ans, right - left + 1);
                        right++;
                    }
                }
                // 当前要升序
                else if (status == 1) {
                    // 如果新加入的比之前的大，说明符合条件，右边界扩展，且下一次要降序
                    if (arr[right] > arr[right - 1]) {
                        status = 2;
                        right++;
                    }
                    // 如果新加入的比之前的小，说明不符合条件，记录当前子数组的长度，并把left设为right-1
                    else if (arr[right] < arr[right - 1]) {
                        ans = Math.max(ans, right - 1 - left + 1);
                        left = right - 1;
                        right++;
                    }
                    else {
                        status = 0;
                        ans = Math.max(ans, right - 1 - left + 1);
                        left = right++;
                    }
                }
                // 当前要降序，逻辑同上
                else if (status == 2) {
                    if (arr[right] > arr[right - 1]) {
                        ans = Math.max(ans, right - 1 - left + 1);
                        left = right - 1;
                        right++;
                    }
                    else if (arr[right] < arr[right - 1]) {
                        status = 1;
                        right++;
                    }
                    else {
                        status = 0;
                        ans = Math.max(ans, right - 1 - left + 1);
                        left = right++;
                    }
                }
            }
            // 因为我们之前是发现非法的时候才更新答案，这里要最后处理一下，覆盖直到处理完成都没有非法出现的情况
            ans = Math.max(ans, right - 1 - left + 1);
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}