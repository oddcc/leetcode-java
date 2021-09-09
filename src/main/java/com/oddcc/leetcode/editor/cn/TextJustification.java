// 68

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(solution.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(solution.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，贪心
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int eachLineWidth = 0;
            int i = 0;
            List<List<String>> wordsInLine = new ArrayList<>();
            // 把单词分配到多行
            while (i < words.length) {
                List<String> lineWords = new ArrayList<>();
                String word = words[i];
                // 因为题目说单个词长度不会超过maxWidth，所以每一行第一个单词一定是可以加入的
                lineWords.add(word);
                eachLineWidth += word.length();
                // 单词之间至少有一个空格，加入这个空格之后，长度不能超过maxWidth，如果满足，则说明下个单词可以加入
                while (i + 1 < words.length && eachLineWidth + words[i + 1].length() + lineWords.size() - 1 + 1 <= maxWidth) {
                    i++;
                    eachLineWidth += words[i].length();
                    lineWords.add(words[i]);
                }
                wordsInLine.add(lineWords);
                i++;
                eachLineWidth = 0;
            }
            // 在多行中插入合适的空格
            List<String> ans = new ArrayList<>();
            for (int x = 0; x < wordsInLine.size(); x++) {
                List<String> lineWords = wordsInLine.get(x);
                // 总共需要插入的空格数量
                int needSpace = maxWidth - lineWords.stream().map(String::length).reduce(0, Integer::sum);
                // 本行一共有多少单词
                int wordCount = lineWords.size();
                StringBuilder sb = new StringBuilder();
                for (String word : lineWords) {
                    // 先插入单词，再计算空格
                    sb.append(word);
                    // 长度没到maxWidth时，流程都没结束
                    if (sb.length() < maxWidth) {
                        // 当只剩一个单词时，应把剩余的位置都用空格填充
                        if (wordCount <= 1) {
                            sb.append(" ".repeat(maxWidth - sb.length()));
                        }
                        else {
                            // 如果处理的是最后一行，那么单词之间不需要额外的空格，1个就足够了
                            if (x == wordsInLine.size() - 1) {
                                sb.append(" ");
                                needSpace--;
                            }
                            // 当处理的不是最后一行，单词之间填充空格要尽量均匀，并且先大后小
                            else {
                                int c = (int) Math.ceil((double) needSpace / (wordCount - 1));
                                sb.append(" ".repeat(c));
                                needSpace -= c;
                            }
                        }
                    }
                    wordCount--;
                }

                ans.add(sb.toString());
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}