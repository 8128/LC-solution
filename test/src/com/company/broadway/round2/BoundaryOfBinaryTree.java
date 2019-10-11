package com.company.broadway.round2;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-08 14:49
 * @leetcode : https://leetcode.com/problems/boundary-of-binary-tree/
 */
public class BoundaryOfBinaryTree {

     public class TreeNode {

         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }

     }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        ans.add(root.val);
        addLeft(ans, root.left);
        leaves(ans, root.left);
        leaves(ans, root.right);
        addRight(ans, root.right);

        return ans;
    }

    public void addLeft(List<Integer> ans, TreeNode root) {
        if(root == null || isLeaf(root)) {
            return;
        }
        ans.add(root.val);
        if(root.left == null) {
            addLeft(ans, root.right);
        } else {
            addLeft(ans, root.left);
        }
    }

    public void addRight(List<Integer> ans, TreeNode root) {
        if(root == null || isLeaf(root)) {
            return;
        }
        if(root.right == null) {
            addRight(ans, root.left);
        } else {
            addRight(ans, root.right);
        }
        ans.add(root.val);
    }

    public void leaves(List<Integer> ans, TreeNode root) {
        if(root == null) {
            return;
        }
        if(isLeaf(root)) {
            ans.add(root.val);
            return;
        }
        leaves(ans, root.left);
        leaves(ans, root.right);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
