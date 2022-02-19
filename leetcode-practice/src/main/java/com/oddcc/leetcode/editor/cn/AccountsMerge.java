// 721

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ArrayListUtils;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        Solution solution = new AccountsMerge().new Solution();
        System.out.println(solution.accountsMerge(ArrayListUtils.arrayToList(new String[][]{{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}})));
        System.out.println(solution.accountsMerge(ArrayListUtils.arrayToList(new String[][]{{"Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"}, {"Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"}, {"Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"}, {"Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co"}, {"Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co"}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 疑问，题目没提到有没有同一个邮箱对应不同名字的情况，业务中有可能出现，但题目中没提到，姑且认为没有
        // 思路1，每个账户的邮箱列表可以视为邻接表，可以构成一张图，每一个连通分量就是一个合并后的账户，还要提前用哈希表
        // 保存好邮箱 -> 账户的映射关系
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Set<String>> graph = new HashMap<>();
            Map<String, String> mailNameMap = new HashMap<>();
            // 构造邻接表，使用每个账户第一个出现的邮箱作为起点
            for (List<String> account : accounts) {
                for (int i = 1; i < account.size(); i++) {
                    if (!mailNameMap.containsKey(account.get(i))) {
                        mailNameMap.put(account.get(i), account.get(0));
                    }
                    if (i == 1) {
                        if (!graph.containsKey(account.get(1))) {
                            graph.put(account.get(1), new HashSet<>());
                        }
                    }
                    else {
                        // 其他结点 -> account.get(1)
                        if (!graph.containsKey(account.get(i))) {
                            graph.put(account.get(i), new HashSet<>());
                        }
                        graph.get(account.get(i)).add(account.get(1));

                        // account.get(1) -> 其他结点
                        graph.get(account.get(1)).add(account.get(i));
                    }
                }
            }
            // 遍历图，每遇到一个新的连通分量，就说明是一个新的账号
            List<List<String>> ans = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            for (String mail : graph.keySet()) {
                if (visited.contains(mail)) continue;
                List<String> account = new ArrayList<>();
                Queue<String> queue = new LinkedList<>();
                queue.add(mail);
                while (!queue.isEmpty()) {
                    String node = queue.remove();
                    if (visited.contains(node)) continue;
                    account.add(node);
                    visited.add(node);
                    for (String next : graph.get(node)) {
                        if (visited.contains(next)) continue;
                        queue.add(next);
                    }
                }
                account.sort(String::compareTo);
                account.add(0, mailNameMap.get(mail));
                ans.add(account);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}