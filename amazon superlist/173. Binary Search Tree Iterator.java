/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Stack<TreeNode> mStack;

    public BSTIterator(TreeNode root) {
        mStack = new Stack<TreeNode>();
        if(root!=null) helper(root);
    }
    
    public void helper(TreeNode root){
        if(root.left==null && root.right==null){
            mStack.push(root);
            return;
        } 
        if(root.right!=null) helper(root.right);
        mStack.push(root);
        if(root.left!=null) helper(root.left);
    }
        
    /** @return the next smallest number */
    public int next() {
        return mStack.pop().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */