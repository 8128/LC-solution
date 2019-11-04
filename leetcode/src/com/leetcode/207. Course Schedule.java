import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dp = new int[numCourses];//并不是dp...可以用color来表示
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();            
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
            //helper本质是一个dfs
            if(dp[i]==0 && helper(i, hm, dp)==false) //如果还没被涂色，那就dfs
                return false;
        }
        return true;
    }
    
    public boolean helper(int i, HashMap<Integer, List<Integer>> hm, int[] dp){
        dp[i] = -1;//涂色，这个点在从子节点退出来之前，暂时不能访问了
        if(hm.containsKey(i)){
            for(int nei: hm.get(i)){//找一下所有的邻居
                if(dp[nei]==0 && helper(nei, hm, dp)==false){//如果nei还是初始的0,说明没访问过,可以dfs
                    return false;
                }
                else if(dp[nei]==-1){//如果遇到了涂色为-1的点,说明成环了
                    return false;
                }
            }
        }
        dp[i] = 1;
        return true; 
    }

    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
    //     boolean[] dp = new boolean[numCourses];
    //     Arrays.fill(dp,false);
    //     for(int[] temp:prerequisites){
    //         if(!hm.containsKey(temp[0])){
    //             List<Integer> mlist = new ArrayList<Integer>();
    //             mlist.add(temp[1]);
    //             hm.put(temp[0],mlist);
    //         }else{
    //             hm.get(temp[0]).add(temp[1]);
    //         }
    //     }
    //     for(int i=0;i<numCourses;i++){
    //         List<Integer> mlist = new ArrayList<Integer>();
    //         if(!helper(i,hm,mlist,dp)) return false;
    //     }
    //     return true;
    // }
    
    // public boolean helper(int i,HashMap<Integer, List<Integer>> hm, List<Integer> mlist, boolean[] dp){
    //     if(dp[i]==true){
    //         return true;
    //     }
    //     if(mlist.contains(i)){
    //         return false;
    //     } 
    //     if(!hm.containsKey(i)){
    //         for(int j:mlist){
    //             dp[j]=true;
    //         }
    //         dp[i]=true;
    //         return true;
    //     }
    //     mlist.add(i);
    //     boolean ans = true;
    //     for(int j:hm.get(i)){
    //         ans = ans && helper(j,hm,mlist,dp);
    //     }
    //     return ans;      
    // }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] testcase = new int[][]{{1,0}};
        System.out.println(test.canFinish(2, testcase));
    }
}