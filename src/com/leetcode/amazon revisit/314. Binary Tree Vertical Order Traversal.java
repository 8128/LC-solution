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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> orderq = new LinkedList<>();
        q.offer(root);
        int pos=0;
        orderq.offer(pos);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            pos = orderq.poll();
            List<Integer> mtemp = hm.getOrDefault(pos,new ArrayList<Integer>());
            mtemp.add(cur.val);
            hm.put(pos,mtemp);
            if(cur.left!=null){
                orderq.offer(pos-1);
                q.offer(cur.left);
            }
            if(cur.right!=null){
                orderq.offer(pos+1);
                q.offer(cur.right);
            }
            //System.out.println(hm.size());
        }
        ArrayList<Integer> temp =new ArrayList<>(hm.keySet());
        //System.out.println(temp);
        Collections.sort(temp);
        for(int i:temp){
            ans.add(hm.get(i));
        }
        return ans;
    }
}