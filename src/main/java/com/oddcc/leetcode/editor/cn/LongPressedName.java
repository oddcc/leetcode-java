package com.oddcc.leetcode.editor.cn;

public class LongPressedName {
    public static void main(String[] args) {
        Solution solution = new LongPressedName().new Solution();
//        System.out.println(solution.isLongPressedName("alex", "aaleex"));
//        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
//        System.out.println(solution.isLongPressedName("leelee", "lleeelee"));
//        System.out.println(solution.isLongPressedName("laiden", "laiden"));
//        System.out.println(solution.isLongPressedName("vtkgn", "vttkgnn"));
//        System.out.println(solution.isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(solution.isLongPressedName("dfuyalc", "fuuyallc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 两个指针，一次遍历
        public boolean isLongPressedName(String name, String typed) {
            int nameIndex = 0;
            Character tmpC = null;
            // 如果跟name相同，则nameIndex++，tmp设为当前字符，如果不同，但是跟tmp相同，则nameIndex不变，如果不同，且跟tmp不同，则返回false
            for (int i = 0; i < typed.length(); i++) {
                char typedChar = typed.charAt(i);
                if (nameIndex > name.length() - 1) {
                    if (tmpC == null) return false;
                    if (tmpC != typedChar) {
                        return false;
                    }
                    else {
                        continue;
                    }
                }
                char nameChar = name.charAt(nameIndex);
                if (nameChar != typedChar) {
                    if (tmpC == null) return false;
                    if (typedChar != tmpC) return false;
                }
                else {
                    nameIndex++;
                    tmpC = nameChar;
                }
            }
            if (name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}