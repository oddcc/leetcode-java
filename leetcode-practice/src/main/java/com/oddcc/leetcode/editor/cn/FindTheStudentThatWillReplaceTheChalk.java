// 1894

package com.oddcc.leetcode.editor.cn;

public class FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        Solution solution = new FindTheStudentThatWillReplaceTheChalk().new Solution();
        System.out.println(solution.chalkReplacer(new int[]{5, 1, 5}, 22));
        System.out.println(solution.chalkReplacer(new int[]{3, 4, 1, 2}, 25));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，利用前缀和数组
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            int len = chalk.length;
            int[] pre = new int[len];
            int tmp = 0;
            for (int i = 0; i < len; i++) {
                tmp += chalk[i];
                if (tmp > k) {
                    return i;
                }
                pre[i] = tmp;
            }

            int sum = pre[len - 1];
            k = k % sum;
            return searchFirstHigher(pre, k, 0, len - 1);
        }

        private int searchFirstHigher(int[] pre, int k, int left, int right) {
            if (right <= left) {
                if (pre[left] > k) {
                    return left;
                }
                return -1;
            }
            int mid = (right - left) / 2 + left;
            if (pre[mid] <= k) {
                return searchFirstHigher(pre, k, mid + 1, right);
            }
            else {
                return searchFirstHigher(pre, k, left, mid);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}