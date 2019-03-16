import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length==0 || edges[0].length==0){
            if(n>1) return false;
            else return true;
        }
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int[] temp:edges){
            if(!hm.containsKey(temp[0])){
                List<Integer> mList = new ArrayList<Integer>();
                mList.add(temp[1]);
                hm.put(temp[0],mList);
            }else{
                hm.get(temp[0]).add(temp[1]);
            }      
            if(!hm.containsKey(temp[1])){
                List<Integer> mList = new ArrayList<Integer>();
                mList.add(temp[0]);
                hm.put(temp[1],mList);
            }else{
                hm.get(temp[1]).add(temp[0]);
            }
        }
        boolean[] bl = new boolean[n];
        Arrays.fill(bl,false);            
        boolean ans = dfs(hm,bl,edges[0][0],edges[0][0]);
        for(boolean mbl:bl){
            if(mbl==false){
                return false;
            }
        }
        return ans;
    }
    
    public boolean dfs(HashMap<Integer,List<Integer>> hm, boolean[] bl, int key, int lastkey){
        boolean ans = true;
        for(int adjacent:hm.get(key)){
            if(bl[adjacent]==true && adjacent != lastkey) return false;
            bl[adjacent] = true;
            if(adjacent!=lastkey) ans = ans && dfs(hm, bl, adjacent, key);
        }
        return ans;
    }
}