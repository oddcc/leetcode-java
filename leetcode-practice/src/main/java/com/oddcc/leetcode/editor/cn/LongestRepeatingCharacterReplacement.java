// 424

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        System.out.println(solution.characterReplacement("ABAB", 2));
        System.out.println(solution.characterReplacement("AABABBA", 1));
        System.out.println(solution.characterReplacement("ABBBCABA", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 例子给的字符串只有A和B，但题目中没提只有两个字符
        // 思路1，枚举每种替换的可能性，找到子串长度最大的情况
        // 思路2，利用滑动窗口
        // 初始情况，滑动窗口内有1个元素，先尝试扩展右边界，如果扩展后除出现次数最多的字符外，剩余的字符个数不超过k个
        // 则记录当前的窗口宽度，如果超过了最大窗口宽度，则更新最大窗口宽度，这个最大宽度就是至今为止出现的最长连续子串的长度
        // 继续尝试扩展右边界
        // 当扩展右边界后发现不符合条件，则缩小左边界
        // 继续尝试扩展右边界，当右边界到达字符串末尾无法再扩展时，流程结束
        public int characterReplacement(String s, int k) {
            int ans = 0;
            int[] charCount = new int[26];
            char[] chars = s.toCharArray();
            int left = 0;
            int right = 0;
            boolean moveRight = true;
            while (right < chars.length) {
                if (moveRight) charCount[chars[right] - 'A']++; // 移动了右边界的情况下，才需要新加入字符；否则会产生重复计算
                int maxCharCount = Arrays.stream(charCount).max().getAsInt();
                int totalCharCount = Arrays.stream(charCount).sum();
                if (totalCharCount - maxCharCount <= k) {
                    ans = Math.max(ans, right - left + 1);
                    right++;
                    moveRight = true;
                    continue;
                }
                charCount[chars[left] - 'A']--;
                left++;
                moveRight = false;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}