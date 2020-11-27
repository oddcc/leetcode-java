// 767

package com.oddcc.leetcode.editor.cn;

import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
        System.out.println(solution.reorganizeString("aab"));
        System.out.println(solution.reorganizeString("aaab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 只包含小写字母
        public String reorganizeString(String S) {
            int[] count = new int[26];
            for (Character c : S.toCharArray()) {
                count[c - 'a']++;
            }
            int maxCount = 0;
            for (int i : count) {
                if (i > maxCount) maxCount = i;
            }
            int len = S.length();
            if (len % 2 == 0) {
                if (maxCount > len / 2) {
                    return "";
                }
            }
            else {
                if (maxCount > len / 2 + 1) {
                    return "";
                }
            }
            //
            PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> count[c2 - 'a'] - count[c1 - 'a']);
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) maxHeap.add((char) (i + 'a'));
            }
            StringBuilder sb = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                Character c1 = maxHeap.poll();
                Character c2 = maxHeap.poll();
                sb.append(c1);
                count[c1 - 'a']--;
                if (count[c1 - 'a'] > 0) maxHeap.add(c1);
                if (c2 != null) {
                    sb.append(c2);
                    count[c2 - 'a']--;
                    if (count[c2 - 'a'] > 0) maxHeap.add(c2);
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}