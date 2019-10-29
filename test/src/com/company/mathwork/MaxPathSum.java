package com.company.mathwork;

import java.util.Queue;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-29 16:18
 * @leetcode : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return ans;
    }

    public int findMax (TreeNode node) {
        int val = node.val;
        int tempLongest = val;
        int left = 0;
        int right = 0;
        if (node.left == null && node.right == null) {
            ans = Math.max(val, ans);
            return val;
        }
        if (node.left != null) {
            left = findMax(node.left);
            tempLongest += left > 0 ? left : 0;
        }
        if (node.right != null) {
            right = findMax(node.right);
            tempLongest += right > 0 ? right : 0;
        }
        ans = Math.max(tempLongest, ans);
        int leftOrRight = Math.max(left, right);
        return Math.max(val, val + leftOrRight);
    }
}
