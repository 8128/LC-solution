import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int[] contribute = new int[D];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dfs(D, weights, 0, contribute, pq);
        return pq.peek();
    }
    
    public void dfs(int D, int[] weights, int i, int[] contribute, PriorityQueue<Integer> pq){
        if(i==weights.length){
            int ans=0;
            System.out.println("-------");
            for(int a:contribute){
                ans = Math.max(a,ans);
                System.out.println(a);
            }
            pq.add(ans);
            return;
        }
        for(int j=0;j<D;j++){
            int[] temp = contribute.clone();
            temp[j] = contribute[j]+weights[i];
            dfs(D, weights, i+1, temp, pq);
        }
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
}