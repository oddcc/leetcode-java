// 1707

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class MaximumXorWithAnElementFromArray {
    public static void main(String[] args) {
        Solution solution = new MaximumXorWithAnElementFromArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maximizeXor(int[] nums, int[][] queries) {
            Arrays.sort(nums);
            int numQ = queries.length;
            int[][] newQueries = new int[numQ][3];
            for (int i = 0; i < numQ; ++i) {
                newQueries[i][0] = queries[i][0];
                newQueries[i][1] = queries[i][1];
                newQueries[i][2] = i;
            }
            Arrays.sort(newQueries, new Comparator<int[]>() {
                public int compare(int[] query1, int[] query2) {
                    return query1[1] - query2[1];
                }
            });

            int[] ans = new int[numQ];
            Trie trie = new Trie();
            int idx = 0, n = nums.length;
            for (int[] query : newQueries) {
                int x = query[0], m = query[1], qid = query[2];
                while (idx < n && nums[idx] <= m) {
                    trie.insert(nums[idx]);
                    ++idx;
                }
                if (idx == 0) { // 字典树为空
                    ans[qid] = -1;
                }
                else {
                    ans[qid] = trie.getMaxXor(x);
                }
            }
            return ans;
        }
    }

    class Trie {
        static final int L = 30;
        Trie[] children = new Trie[2];

        public void insert(int val) {
            Trie node = this;
            for (int i = L - 1; i >= 0; --i) {
                int bit = (val >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
            }
        }

        public int getMaxXor(int val) {
            int ans = 0;
            Trie node = this;
            for (int i = L - 1; i >= 0; --i) {
                int bit = (val >> i) & 1;
                if (node.children[bit ^ 1] != null) {
                    ans |= 1 << i;
                    bit ^= 1;
                }
                node = node.children[bit];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}