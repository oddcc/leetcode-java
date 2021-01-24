// 438

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，从前到后每个位置都往后找，判断一下是否满足条件，在特殊的用例下会超时，最差情况是O(n^2)的时间复杂度
        // 思路2，滑动窗口，因为字母异位词的长度与原字符串相同，所以我们只需要检查特定长度之中的子串是否符合条件；
        // 另外，没必要像思路1一样，每次都从起点开始找，我们只需要让左边一个字母移出窗口，右边一个字母移入窗口即可
        // 对判断异位词来说，只需要判断新加入的一个字母就可以，其他信息都可以利用现有的信息
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int start = 0;
            int end = 0;
            int[] originCharCount = new int[26];
            for (char c : p.toCharArray()) {
                originCharCount[c - 'a']++;
            }
            int[] charCount = new int[26];
            while (end < s.length()) {
                if (end - start < p.length()) {
                    charCount[s.charAt(end) - 'a']++;
                    end++;
                    continue;
                }
                // end - start + 1 == p.length()
                if (valid(charCount, originCharCount)) {
                    ans.add(start);
                }
                charCount[s.charAt(start) - 'a']--;
                start++;
                charCount[s.charAt(end) - 'a']++;
                end++;
            }
            if (valid(charCount, originCharCount)) {
                ans.add(start);
            }
            return ans;
        }

        private boolean valid(int[] charCount, int[] originCharCount) {
            if (charCount.length != originCharCount.length) return false;
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] != originCharCount[i]) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}