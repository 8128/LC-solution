package com.v.blend.voonsite;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 03:08
 * @leetcode :  https://leetcode.com/problems/binary-tree-upside-down/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class BinaryTreeUpsideDown {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursive
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // if root == null it should return itself
        // if root.left == null then it means that it is the new root
        if(root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        // the node one the left side will be on the top
        // node 2 left children
        root.left.left = root.right;
        // node 2 right children
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }


    // iterative
    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while(curr != null) {
            next = curr.left;

            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
