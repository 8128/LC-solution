import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        boolean[] dp = new boolean[numCourses];
        Arrays.fill(dp,false);
        for(int[] temp:prerequisites){
            if(!hm.containsKey(temp[0])){
                List<Integer> mlist = new ArrayList<Integer>();
                mlist.add(temp[1]);
                hm.put(temp[0],mlist);
            }else{
                hm.get(temp[0]).add(temp[1]);
            }
        }
        for(int i=0;i<numCourses;i++){
            List<Integer> mlist = new ArrayList<Integer>();
            if(!helper(i,hm,mlist,dp)) return false;
        }
        return true;
    }
    
    public boolean helper(int i,HashMap<Integer, List<Integer>> hm, List<Integer> mlist, boolean[] dp){
        if(dp[i]==true){
            return true;
        }
        if(mlist.contains(i)){
            return false;
        } 
        if(!hm.containsKey(i)){
            for(int j:mlist){
                dp[j]=true;
            }
            dp[i]=true;
            return true;
        }
        mlist.add(i);
        boolean ans = true;
        for(int j:hm.get(i)){
            ans = ans && helper(j,hm,mlist,dp);
        }
        return ans;      
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] testcase = new int[][]{{1,0}};
        System.out.println(test.canFinish(2, testcase));
    }
}