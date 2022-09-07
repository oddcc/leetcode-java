// 1592

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {
    public static void main(String[] args) {
        Solution solution = new RearrangeSpacesBetweenWords().new Solution();
        System.out.println(solution.reorderSpaces("  this   is  a sentence "));
        System.out.println(solution.reorderSpaces(" practice   makes   perfect"));
        System.out.println(solution.reorderSpaces("hello   world"));
        System.out.println(solution.reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(solution.reorderSpaces("a"));
        System.out.println(solution.reorderSpaces("  hello"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorderSpaces(String text) {
            StringBuilder sb = new StringBuilder();
            List<String> words = new ArrayList<>();
            StringBuilder wordSb = new StringBuilder();
            boolean isWord = false;
            int spaceCount = 0;
            for (Character c : text.toCharArray()) {
                if (isWord) {
                    if (c == ' ') {
                        words.add(wordSb.toString());
                        spaceCount++;
                        isWord = false;
                        wordSb = new StringBuilder();
                    } else {
                        wordSb.append(c);
                    }
                } else {
                    if (c == ' ') {
                        spaceCount++;
                    } else {
                        isWord = true;
                        wordSb.append(c);
                    }
                }
            }
            if (wordSb.length() > 0) {
                words.add(wordSb.toString());
            }

            int wordCount = words.size();
            int spanCount = wordCount - 1;
            int eachSpan = spanCount == 0 ? spaceCount : spaceCount / spanCount;
            int remain = spanCount == 0 ? spaceCount : spaceCount % spanCount;

            int i = 0;
            sb.append(words.get(i++));
            for (int j = 0; j < spanCount; j++) {
                for (int c = 0; c < eachSpan; c++) {
                    sb.append(" ");
                }
                sb.append(words.get(i++));
            }
            for (int c = 0; c < remain; c++) {
                sb.append(" ");
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}