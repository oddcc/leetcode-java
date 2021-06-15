// 278

package com.oddcc.leetcode.editor.cn;

public class FirstBadVersion {
    public static void main(String[] args) {
        Solution solution = new FirstBadVersion().new Solution();
        solution.setBad(4);
        System.out.println(solution.firstBadVersion(5));
        solution.setBad(1);
        System.out.println(solution.firstBadVersion(1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    // 思路1，二分查找
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            return searchFirst(1, n);
        }

        private int searchFirst(int left, int right) {
            if (left >= right) return left;
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                return searchFirst(left, mid);
            }
            else {
                return searchFirst(mid + 1, right);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    private class VersionControl {
        private int bad;

        public boolean isBadVersion(int version) {
            return version >= getBad();
        }

        public int getBad() {
            return bad;
        }

        public void setBad(int bad) {
            this.bad = bad;
        }
    }

}