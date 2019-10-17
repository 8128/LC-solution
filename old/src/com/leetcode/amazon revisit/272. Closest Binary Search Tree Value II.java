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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<TreeNode> heap = new PriorityQueue<>(new Comparator<TreeNode>(){
            public int compare(TreeNode node1, TreeNode node2){
                double a = Math.abs(node1.val-target);
                double b = Math.abs(node2.val-target);
                if(a-b>0) return -1;
                if(a-b<0) return 1;
                return 0;
            }
        });
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                double minus = Math.abs(temp.val-target);
                if(heap.size()<k){
                    heap.offer(temp);
                }else{
                    double worst = Math.abs(heap.peek().val-target);
                    if(worst>minus){
                        heap.poll();
                        heap.offer(temp);
                    }
                }
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!heap.isEmpty()){
            ans.add(heap.poll().val);
        }
        return ans;
    }
}