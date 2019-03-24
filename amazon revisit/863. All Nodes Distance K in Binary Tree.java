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

    //bfs
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode,List<TreeNode>> hm = new HashMap<>();
        if(root.left!=null) buildGraph(root,root.left,hm);
        if(root.right!=null) buildGraph(root,root.right,hm);
        List<TreeNode> accessed = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(K==0){
            ans.add(target.val);
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        accessed.add(target);
        q.offer(target);
        int depth=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(hm.get(node)==null) break;
                for(TreeNode temp:hm.get(node)){
                    if(accessed.contains(temp)) continue;
                    q.offer(temp);
                    accessed.add(temp);
                }
            }
            depth++;
            if(depth==K){
                while(!q.isEmpty()){
                    ans.add(q.poll().val);
                }
                break;
            }
        }
        return ans;
    }

    //dfs
    // public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    //     HashMap<TreeNode,List<TreeNode>> hm = new HashMap<>();
    //     if(root.left!=null) buildGraph(root,root.left,hm);
    //     if(root.right!=null) buildGraph(root,root.right,hm);
    //     List<TreeNode> accessed = new ArrayList<>();
    //     List<Integer> ans = new ArrayList<>();
    //     if(K==0){
    //         ans.add(target.val);
    //         return ans;
    //     }
    //     accessed.add(target);
    //     dfs(K,target,0,hm,accessed,ans);
    //     return ans;
    // }
    
    public void buildGraph(TreeNode parent, TreeNode child, HashMap<TreeNode,List<TreeNode>> hm){
        List<TreeNode> mList1 = hm.getOrDefault(parent,new ArrayList<TreeNode>());
        List<TreeNode> mList2 = hm.getOrDefault(child,new ArrayList<TreeNode>());
        mList1.add(child);
        mList2.add(parent);
        hm.put(parent,mList1);
        hm.put(child,mList2);
        if(child.left!=null) buildGraph(child,child.left,hm);
        if(child.right!=null) buildGraph(child,child.right,hm);
    }
    
    // public void dfs(int K, TreeNode cur,int depth, HashMap<TreeNode,List<TreeNode>> hm, List<TreeNode> accessed, List<Integer> ans){
    //     if(depth>=K) return;
    //     if(hm.isEmpty()) return;
    //     for(TreeNode temp:hm.get(cur)){
    //         if(accessed.contains(temp)) continue;
    //         List<TreeNode> copyAccessed = new ArrayList<>(accessed);
    //         copyAccessed.add(temp);
    //         if(depth+1==K){
    //             ans.add(temp.val);
    //             continue;
    //         }
    //         dfs(K,temp,depth+1,hm,copyAccessed,ans);
    //     }
    // }
}