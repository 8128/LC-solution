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


    // better answer
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
        return null;
    
        if (root.val <= p.val) {
        return successor(root.right, p);
        } else {
        TreeNode left = successor(root.left, p);
        return (left != null) ? left : root;
        }
    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> mlist = inorderTraversal(root);
        for(int i=0;i<mlist.size();i++){
            if(p.val==mlist.get(i).val){
                return i<(mlist.size()-1) ?  mlist.get(i+1) : null; 
            }
        }
        return null;
    }
    
    
    public List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur);
            cur = cur.right;
        }

        return list;
    }
}