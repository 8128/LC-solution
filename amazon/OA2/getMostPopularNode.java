/**
 * Author: tty8128
 * Time: 2019.Mar.10
 */

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
        PriorityQueue<CategoryNode> pq = new PriorityQueue<CategoryNode>((a,b)->(hm.get(b)[1]/hm.get(b)[0])-hm.get(a)[1]/hm.get(a)[0]);
        for(CategoryNode key:hm.keySet()){
            if(hm.get(key)[0]==1){
                continue;
            }
            pq.offer(key);
        }
        return pq.peek();
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

    public static void main(String[] args) {
        //             20
        //          12     18
        //        11 2 3  15 8
        Solution test = new Solution();
        Solution.CategoryNode root = test.new CategoryNode(20);
        Solution.CategoryNode a = test.new CategoryNode(12);
        Solution.CategoryNode b = test.new CategoryNode(18);
        Solution.CategoryNode c = test.new CategoryNode(11);
        Solution.CategoryNode d = test.new CategoryNode(2);
        Solution.CategoryNode e = test.new CategoryNode(3);
        Solution.CategoryNode f = test.new CategoryNode(15);
        Solution.CategoryNode g = test.new CategoryNode(8);
        ArrayList<CategoryNode> list1 = new ArrayList<CategoryNode>();
        list1.add(a);
        list1.add(b);
        ArrayList<CategoryNode> list2 = new ArrayList<CategoryNode>();
        list2.add(c);
        list2.add(d);
        list2.add(e);
        ArrayList<CategoryNode> list3 = new ArrayList<CategoryNode>();
        list3.add(f);
        list3.add(g);
        root.subCategoryNode = list1;
        a.subCategoryNode = list2;
        b.subCategoryNode = list3;
        System.out.println(test.getMostPopularNode(root).value);
    }
}