// 1442

package com.oddcc.leetcode.editor.cn;

public class CountTripletsThatCanFormTwoArraysOfEqualXor {
    public static void main(String[] args) {
        Solution solution = new CountTripletsThatCanFormTwoArraysOfEqualXor().new Solution();
        System.out.println(solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(solution.countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution.countTriplets(new int[]{2, 3}));
        System.out.println(solution.countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(solution.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 利用前缀异或数组,可以在O(1)的时间复杂度内判断一组i,j,k是否满足条件
    // 思路1，暴力法，遍历所有可能，O(n^3)的时间复杂度
    class Solution {
        public int countTriplets(int[] arr) {
            int len = arr.length;
            // 计算前缀异或数组
            int[] preArr = new int[len];
            preArr[0] = arr[0];
            for (int i = 1; i < len; i++) {
                preArr[i] = arr[i] ^ preArr[i - 1];
            }
            // 三重循环计算答案
            int ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j; k < len; k++) {
                        int a = preArr[j - 1] ^ (i >= 1 ? preArr[i - 1] : 0);
                        int b = preArr[k] ^ preArr[j - 1];
                        if (a == b) ans++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}