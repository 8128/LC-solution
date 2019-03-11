import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution{
    public class CategoryNode{
        public int value;
        public ArrayList<CategoryNode> subCategoryNode;
        public CategoryNode(){
            subCategoryNode = new ArrayList<CategoryNode>();
        }
        public CategoryNode(int tenure){
            this.value=tenure;
            this.subCategoryNode=new ArrayList<CategoryNode>();
        }
    }

    public CategoryNode getMostPopularNode(CategoryNode rootCategoryNode){
        HashMap<CategoryNode,int[]> hm = new HashMap<CategoryNode,int[]>();
        helper(rootCategoryNode, hm);      
        PriorityQueue<CategoryNode> pq = new PriorityQueue<CategoryNode>((a,b)->(hm.get(a)[1]/hm.get(a)[0]-hm.get(b)[1]/hm.get(b)[0]));
        for(CategoryNode key:hm.keySet()){
            pq.push(key);
        }
        return pq.poll();
    }

    public void helper(CategoryNode cur, HashMap<CategoryNode,int[]> hm){      
        int curNum = 1;
        int sum = cur.value;
        for(CategoryNode node:cur.subCategoryNode){
            if(node.subCategoryNode.size()==0){
                int[] temp = new int[]{1,node.value};
                hm.put(node, temp);
            }else{
                helper(node, hm);
            }
            curNum+=hm.get(node)[0];
            sum +=hm.get(node)[1];
        }
        hm.put(cur,new int[]{curNum,sum});
    }
}