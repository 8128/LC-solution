package com.v.bloomberg.coding;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-07 00:34
 * @leetcode : https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBSTII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return treeGenerator(1, n);
    }

    public List<TreeNode> treeGenerator(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            List<TreeNode> leftTrees = treeGenerator(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            List<TreeNode> rightTrees = treeGenerator(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode newTree = new TreeNode(i);
                    newTree.left = l;
                    newTree.right = r;
                    ans.add(newTree);
                }
            }
        }
        return ans;
    }





    // DP
    public List<TreeNode> generateTreesDP(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}