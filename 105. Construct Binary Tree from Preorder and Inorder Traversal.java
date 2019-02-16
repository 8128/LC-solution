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
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder.length!=inorder.length || preorder.length==0 || inorder.length==0) return null;
//         TreeNode root = new TreeNode(preorder[0]);
//         int plen=preorder.length-1;
//         int ilen=plen;
//         HashMap<Integer,Integer> hm = new HashMap();
//         for(int i=0;i<preorder.length;i++){
//             hm.put(inorder[i],i);
//         }
//         int ppos=1,ipos=hm.get(preorder[0]);
//         buildTreeHelper(preorder,inorder,plen,ilen,root,hm,ppos,ipos);
//         return root;
//     }
    
//     public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int plen, int ilen, TreeNode node, HashMap<Integer,Integer> hm, int ppos,int ipos){
//         if(ppos>plen) return node;
//         TreeNode tempNodeL = new TreeNode(preorder[ppos]);
//         int index = hm.get(preorder[ppos]);
//         if(index < ipos){
//             node.left = tempNodeL;
//             ppos++;
//         }
//         index = hm.get(preorder[ppos]);
//         TreeNode tempNodeR = new TreeNode(preorder[ppos]);
//         if(index > ipos){
//             node.right = tempNodeR;
//             ppos++;
//         }
//         index = hm.get(preorder[ppos]);
//         if(index<ipos){
//             node = buildTreeHelper(preorder,inorder,plen,ilen,tempNodeL,hm,ppos++,hm.get(preorder[ppos]));
//         }else if(index >ipos){
//             node = buildTreeHelper(preorder,inorder,plen,ilen,tempNodeR,hm,ppos++,hm.get(preorder[ppos]));
//         }
//         return node;
//     }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
