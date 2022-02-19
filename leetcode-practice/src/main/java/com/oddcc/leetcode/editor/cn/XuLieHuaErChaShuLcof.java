// 剑指 Offer 37

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        XuLieHuaErChaShuLcof o = new XuLieHuaErChaShuLcof();
        o.test();
    }

    private void test() {
        Codec codec = new Codec();
        TreeNode t = TreeNode.constructFromArr(1, 2, 3, null, null, 4, 5);
        String serialization = codec.serialize(t);
        System.out.println(serialization);
        System.out.println(Arrays.toString(TreeNode.toArr(codec.deserialize(serialization))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addFirst(root);
            List<String> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode n = queue.removeLast();
                    if (n == null) {
                        ans.add("null");
                        continue;
                    }
                    ans.add(Integer.toString(n.val));
                    queue.addFirst(n.left);
                    queue.addFirst(n.right);
                }
                if (queue.stream().allMatch(Objects::isNull)) break;
            }
            return String.join(",", ans);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Deque<String> queue = new LinkedList<>();
            for (String s: data.split(",")) queue.addFirst(s);
            TreeNode root = null;
            if (!(queue.isEmpty() || queue.peekLast().equals("null"))) {
                root = new TreeNode(Integer.parseInt(queue.removeLast()));
            }
            Deque<TreeNode> nodesQueue = new LinkedList<>();
            nodesQueue.addFirst(root);
            while (!queue.isEmpty()) {
                TreeNode cur = nodesQueue.removeLast();
                if (cur == null) continue;
                String s = queue.removeLast();
                if (!s.equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(s));
                    cur.left = left;
                    nodesQueue.addFirst(left);
                }

                s = queue.removeLast();
                if (!s.equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(s));
                    cur.right = right;
                    nodesQueue.addFirst(right);
                }
            }
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)

}