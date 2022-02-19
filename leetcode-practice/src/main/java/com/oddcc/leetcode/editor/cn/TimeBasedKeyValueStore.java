// 981

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
        obj.test();
    }

    private void test() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);         // return "bar2"
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 关键是对一个值x，找存在的小于等于x的第一个值
    class TimeMap {
        class Pair implements Comparable<Pair> {
            int timestamp;
            String value;

            public Pair(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }

            public int hashCode() {
                return timestamp + value.hashCode();
            }

            public boolean equals(Object obj) {
                if (obj instanceof Pair) {
                    Pair pair2 = (Pair) obj;
                    return this.timestamp == pair2.timestamp && this.value.equals(pair2.value);
                }
                return false;
            }

            public int compareTo(Pair pair2) {
                if (this.timestamp != pair2.timestamp) {
                    return this.timestamp - pair2.timestamp;
                }
                else {
                    return this.value.compareTo(pair2.value);
                }
            }
        }

        private Map<String, List<Pair>> cache;

        public TimeMap() {
            cache = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Pair> pairs = cache.getOrDefault(key, new ArrayList<Pair>());
            pairs.add(new Pair(timestamp, value));
            cache.put(key, pairs);
        }

        public String get(String key, int timestamp) {
            List<Pair> pairs = cache.getOrDefault(key, new ArrayList<Pair>());
            Pair pair = new Pair(timestamp, String.valueOf((char) 127));
            int i = binarySearch(pairs, pair);
            String ans = "";
            if (i > 0) {
                ans = pairs.get(i - 1).value;
            }
            System.out.println(ans);
            return ans;
        }

        private int binarySearch(List<Pair> pairs, Pair target) {
            int low = 0, high = pairs.size() - 1;
            if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
                return high + 1;
            }
            while (low < high) {
                int mid = (high - low) / 2 + low;
                Pair pair = pairs.get(mid);
                if (pair.compareTo(target) <= 0) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            return low;
        }
    }

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}