package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 11/8/2019 3:35 AM
 * @leetcode :  https://leetcode.com/problems/find-duplicate-subtrees/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class FindDuplicateSubtrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int t;
    // to restore the tree and the id
    Map<String, Integer> trees;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public String lookup(TreeNode node) {
        if (node == null) return "";
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        trees.put(serial, trees.getOrDefault(serial, 0) + 1);
        if (trees.get(serial) == 2)
            ans.add(node);
        return serial;
    }
}
