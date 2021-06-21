// 1600

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class ThroneInheritanceWrapper {
    public static void main(String[] args) {
        ThroneInheritanceWrapper o = new ThroneInheritanceWrapper();
        o.test();
    }

    private void test() {
        ThroneInheritance o = new ThroneInheritance("king");
        o.birth("king", "andy");
        o.birth("king", "bob");
        o.birth("king", "catherine");
        o.birth("andy", "matthew");
        o.birth("bob", "alex");
        o.birth("bob", "asha");
        System.out.println(o.getInheritanceOrder());
        o.death("bob");
        System.out.println(o.getInheritanceOrder());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ThroneInheritance {
        private String kingName;
        private Map<String, List<String>> cache = new HashMap<>();
        private Set<String> dead = new HashSet<>();

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            cache.put(this.kingName, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            if (cache.containsKey(parentName)) {
                cache.get(parentName).add(childName);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(childName);
                cache.put(parentName, l);
            }
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<>();
            if (!dead.contains(kingName)) ans.add(kingName);
            search(kingName, ans);
            return ans;
        }

        private void search(String name, List<String> ans) {
            if (!cache.containsKey(name)) return;
            for (String child: cache.get(name)) {
                if (!dead.contains(child)) {
                    ans.add(child);
                }
                search(child, ans);
            }
        }
    }

    /**
     * Your ThroneInheritance object will be instantiated and called as such:
     * ThroneInheritance obj = new ThroneInheritance(kingName);
     * obj.birth(parentName,childName);
     * obj.death(name);
     * List<String> param_3 = obj.getInheritanceOrder();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}