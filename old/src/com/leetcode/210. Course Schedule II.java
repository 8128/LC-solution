import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] temp:prerequisites){
            if(!hm.containsKey(temp[0])){
                List<Integer> mlist = new ArrayList<Integer>();
                mlist.add(temp[1]);
                hm.put(temp[0],mlist);
            }else{
                hm.get(temp[0]).add(temp[1]);
            }
        }
        ArrayList<Integer> mList = new ArrayList<>();
        int[] flag = new int[numCourses];
        Arrays.fill(flag, 0);
        for(int i=0;i<numCourses;i++){
            if(!helper(i, hm, mList, flag)){
                return new int[]{};
            }
        }
        int[] ans = new int[numCourses];
        int k=0;
        for(int m:mList){
            ans[k]=m;
            k++;
        }
        return ans;
    }

    public boolean helper(int i, HashMap<Integer,List<Integer>> hm, ArrayList<Integer> mlist, int[] flag){
        if(!hm.containsKey(i)){
            if(flag[i]==0){
                mlist.add(i);
                flag[i]=1;
                return true;
            }
            if(flag[i]==-1) return false;
            if(flag[i]==1) return true;
        }
        if(flag[i]==-1) return false;
        if(flag[i]==1) return true;
        flag[i]=-1;
        for(int j:hm.get(i)){
            if(!helper(j,hm,mlist,flag)){
                return false;
            }
        }
        mlist.add(i); 
        flag[i]=1;
        return true;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        int[][] temp = new int[][]{{1,2},{2,4},{3,6}};
        for(int m:mSolution.findOrder(7, temp)){
            System.out.println(m);
        }
    }
}