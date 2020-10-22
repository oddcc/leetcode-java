package com.oddcc.leetcode.editor.cn;

public class LongPressedName {
    public static void main(String[] args) {
        Solution solution = new LongPressedName().new Solution();
        System.out.println(solution.isLongPressedName("alex", "aaleex")); // T
        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));// F
        System.out.println(solution.isLongPressedName("leelee", "lleeelee"));// T
        System.out.println(solution.isLongPressedName("laiden", "laiden"));// T
        System.out.println(solution.isLongPressedName("vtkgn", "vttkgnn"));// T
        System.out.println(solution.isLongPressedName("pyplrz", "ppyypllr"));// F
        System.out.println(solution.isLongPressedName("dfuyalc", "fuuyallc"));// F
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 两个指针，一次遍历
        public boolean isLongPressedName(String name, String typed) {
            int pName = 0;
            int pTyped = 0;
            Character lastChar = null;
            while (pName < name.length() || pTyped < typed.length()) {
                if (pName >= name.length()) pName = name.length() - 1; // 这种情况，会出现在 vtkgn vttkgnn 满足条件之后 typed 都是重复的，会继续往后走
                if (pTyped >= typed.length()) return false; // 这种情况，会出现在 pyplrz ppyypllrrrrrr，name一直没满足，typed一直往后走
                char nameChar = name.charAt(pName);
                char typedChar = typed.charAt(pTyped);
                if (nameChar == typedChar) {
                    lastChar = typedChar;
                    pName++;
                    pTyped++;
                }
                else {
                    if (lastChar != null && typedChar == lastChar) {
                        pTyped++;
                    }
                    else {
                        return false;
                    }
                }
            }
            return pName == name.length() && pTyped == typed.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}