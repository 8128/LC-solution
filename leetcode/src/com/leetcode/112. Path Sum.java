/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        
        int remain = sum-root.val;
        if(root.left!=null){
            TreeNode cur = root.left;
            ans = ans||hasPathSum(cur,remain);
        }
        if(root.right!=null){
            TreeNode cur = root.right;
            ans = ans||hasPathSum(cur,remain);
        }
        if(root.left==null&&root.right==null&&remain==0){
            ans=true;
        }else{
            ans=false||ans;
        }
        return ans;
    }
}
