// 830

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
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
        // 思路2，优化思路1，扫描是从前到后，所以结果自然是按start升序排列的，不需要再进行排序
        // 思路3，思路1、2都是从第0个字符开始比较，采用从第1个字符开始比较的方式，代码稍微简单一点
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> ans = new ArrayList<>();
            int start = 0;
            int end = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == (s.charAt(i))) {
                    end++;
                    if (i == s.length() - 1) {
                        if (end - start + 1 >= 3) {
                            List<Integer> a = new ArrayList<>();
                            a.add(start);
                            a.add(end);
                            ans.add(a);
                        }
                    }
                }
                else {
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
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}