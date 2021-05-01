// 690

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class EmployeeImportance {
    public static void main(String[] args) {
        Solution solution = new EmployeeImportance().new Solution();
        System.out.println(solution.getImportance(Arrays.asList(
                Employee.cons(1, 5, 2, 3),
                Employee.cons(2, 3),
                Employee.cons(3, 3)
        ), 1));
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        static Employee cons(Integer id, Integer importance, Integer... subordinates) {
            return new Employee(id, importance, Arrays.asList(subordinates));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，哈希表+递归
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> map = new HashMap<>();
            for (Employee e : employees) map.put(e.id, e);
            return getImportance(map, id);
        }

        private int getImportance(Map<Integer, Employee> map, int id) {
            Employee e = map.get(id);
            int ans = 0;
            if (e != null) {
                ans += e.importance;
                for (Integer subId : e.subordinates) {
                    ans += getImportance(map, subId);
                }
                return ans;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}