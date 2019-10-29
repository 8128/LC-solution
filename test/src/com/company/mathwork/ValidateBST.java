package com.company.mathwork;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-29 15:20
 * @leetcode : https://leetcode.com/problems/validate-binary-search-tree/
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        else {
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
    }

    public static void main(String[] args) {

    }
}
