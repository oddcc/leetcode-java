// 208

package com.oddcc.leetcode.editor.cn;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        ImplementTriePrefixTree test = new ImplementTriePrefixTree();
        test.test();
    }

    private void test() {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple")); // true
        System.out.println(obj.search("app")); // false
        System.out.println(obj.startsWith("app")); // true
        obj.insert("app");
        System.out.println(obj.search("app")); // true
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        // 因为题目中节点只存小写英文字母，所以存储空间可以优化
        private class Node {
            private Node[] children;
            private final int R = 26;
            private Boolean isEnd;

            public Node(Character c) {
                this.children = new Node[R];
                this.isEnd = false;
            }

            private Node find(Character c) {
                return this.children[c - 'a'];
            }

            private void put(Node n, Character c) {
                if (c == null) return;
                this.children[c - 'a'] = n;
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new Node(null);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node parent = this.root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Node n = parent.find(chars[i]);
                if (n == null) {
                    n = new Node(chars[i]);
                }
                if (i == chars.length - 1) {
                    n.isEnd = true;
                }
                parent.put(n, chars[i]);
                parent = n;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node r = this.root;
            for (int i = 0; i < chars.length; i++) {
                Node t = r.find(chars[i]);
                if (t != null) {
                    r = t;
                }
                else {
                    return false;
                }
                if (i == chars.length - 1) {
                    return t.isEnd;
                }
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node r = this.root;
            for (int i = 0; i < chars.length; i++) {
                Node t = r.find(chars[i]);
                if (t != null) {
                    r = t;
                }
                else {
                    return false;
                }
                if (i == chars.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}