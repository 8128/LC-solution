package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 16:07
 * @leetcode :  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class VerticalOrderTraversalofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // what if in the same depth and also in the same vertical line there are several different nodes
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }



    // put it by fif
    public List<List<Integer>> verticalTraversal1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<Integer>> posNode = new TreeMap<>();
        HashMap<TreeNode, Integer> nodePos = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        q.offer(root);
        List<Integer> midList = new ArrayList<>();
        midList.add(root.val);
        posNode.put(0, midList);
        nodePos.put(root, 0);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                int pos = nodePos.get(node);
                if (node.left != null) {
                    List<Integer> list = posNode.getOrDefault(pos - 1, new ArrayList());
                    list.add(node.left.val);
                    posNode.put(pos - 1, list);
                    nodePos.put(node.left, pos - 1);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    List<Integer> list = posNode.getOrDefault(pos + 1, new ArrayList());
                    list.add(node.right.val);
                    posNode.put(pos + 1, list);
                    nodePos.put(node.right, pos + 1);
                    q.offer(node.right);
                }
            }
        }
        for (int i : posNode.keySet()) {
            ans.add(posNode.get(i));
        }
        return ans;
    }
}
