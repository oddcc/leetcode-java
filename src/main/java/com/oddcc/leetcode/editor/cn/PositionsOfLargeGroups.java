// 830

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PositionsOfLargeGroups {
    public static void main(String[] args) {
        Solution solution = new PositionsOfLargeGroups().new Solution();
        System.out.println(solution.largeGroupPositions("abbxxxxzzy"));
        System.out.println(solution.largeGroupPositions("abc"));
        System.out.println(solution.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(solution.largeGroupPositions(""));
        System.out.println(solution.largeGroupPositions("abccc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，单指针扫描计数，如果长度>=3就加入结果集，返回结果之前排序
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> ans = new ArrayList<>();
            int start = 0;
            int end = 0;
            Character pre = null;
            for (int i = 0; i < s.length(); i++) {
                if (i == 0) {
                    pre = s.charAt(i);
                    continue;
                }
                if (pre.equals(s.charAt(i))) {
                    end++;
                }
                else {
                    pre = s.charAt(i);
                    if (end - start + 1 >= 3) {
                        List<Integer> a = new ArrayList<>();
                        a.add(start);
                        a.add(end);
                        ans.add(a);
                    }
                    start = i;
                    end = i;
                }
            }
            if (end - start + 1 >= 3) {
                List<Integer> a = new ArrayList<>();
                a.add(start);
                a.add(end);
                ans.add(a);
            }
            ans.sort(Comparator.comparingInt(l -> l.get(0)));
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}