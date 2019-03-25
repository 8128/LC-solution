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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if(root==null) return ans;
        nodes.add(root);
        while(!nodes.isEmpty()){
            TreeNode temp = nodes.pollLast();
            ans.offerFirst(temp.val);
            if(temp.left!=null) nodes.offerLast(temp.left);
            if(temp.right!=null) nodes.offerLast(temp.right);
        }
        return ans;
    }
}