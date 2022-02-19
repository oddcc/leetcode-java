// 1823

package com.oddcc.leetcode.editor.cn;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        Solution solution = new FindTheWinnerOfTheCircularGame().new Solution();
        System.out.println(solution.findTheWinner(5, 2));
        System.out.println(solution.findTheWinner(6, 5));
        System.out.println(solution.findTheWinner(3, 1));
        System.out.println(solution.findTheWinner(5, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接模拟，利用Set存淘汰的数，移动时跳过已淘汰的数，并记录当前还剩几个人count，当count==1时，剩下的就是答案
        public int findTheWinner(int n, int k) {
            // 编号为0~n-1，共n个，exist[i] == false说明第i-1个人已经被淘汰了
            boolean[] left = new boolean[n];
            int remain = n;
            int start = 0;
            while (remain > 1) {
                start = findNext(start, k, left);
                left[start] = true;
                start = findNext(start, 1, left);
                remain--;
            }
            int ans = -1;
            for (int i = 0; i < n; i++) {
                if (!left[i]) {
                    ans = i;
                    break;
                }
            }
            return ans + 1;
        }

        /**
         *
         * @param start 起点
         * @param count 包含start在内，应该有count个节点满足left[i] == false
         * @param left 记录状态
         * @return 最后一个满足left[i] == false的位置i
         */
        private int findNext(int start, int count, boolean[] left) {
            while (count > 0) {
                start %= left.length;
                if (left[start]) {
                    start++;
                    continue;
                }
                count--;
                if (count > 0) start++;
            }
            return start % left.length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}