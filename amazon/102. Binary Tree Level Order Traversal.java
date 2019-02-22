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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> row = new LinkedList<Integer>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                row.add(temp.val);
                if(temp.left!=null) {
                    q.offer(temp.left);
                }
                if(temp.right!=null) {
                    q.offer(temp.right);
                }                
            }
            ans.add(row);
        }
        return ans;
    }
}