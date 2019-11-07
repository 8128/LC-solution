package com.v.bloomberg.coding;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 03:58
 * @leetcode :  https://leetcode.com/problems/merge-two-binary-trees/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class MergeTwoBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
