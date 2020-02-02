package com.contest.feb1;


import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-02-01 21:50
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


class Solution {
    public int maxProduct(TreeNode root) {
        int sum = helper(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        long max = Long.MIN_VALUE;
        long k = 1000000007;
        System.out.println(k);
        System.out.println("....");
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, ((long)(sum - node.val) * (long)(node.val)));
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return (int)(max % k);
    }

    public int helper (TreeNode cur) {
        if (cur.left == null && cur.right == null) return cur.val;
        int left = cur.left == null ? 0 : helper(cur.left);
        int right = cur.right == null ? 0 : helper(cur.right);
        cur.val = left + right + cur.val;
        return cur.val;
    }

    public static void main(String[] args) {
        new Solution().maxProduct(new TreeNode(1));
    }
}
