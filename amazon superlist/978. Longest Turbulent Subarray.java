class Solution {
    public int maxTurbulenceSize(int[] A) {
        int[] dp_sit1 = new int[A.length];
        int[] dp_sit2 = new int[A.length];
        int ans=1;
        Arrays.fill(dp_sit1,1);
        Arrays.fill(dp_sit2,1);
        for(int i=1;i<A.length;i++){
            boolean even=false;
            if(i%2==0) even=true;
            if(even){
                if(A[i-1]>A[i]) dp_sit1[i] = dp_sit1[i-1]+1;
                if(A[i-1]<A[i]) dp_sit2[i] = dp_sit2[i-1]+1;
            }else{
                if(A[i-1]<A[i]) dp_sit1[i] = dp_sit1[i-1]+1;
                if(A[i-1]>A[i]) dp_sit2[i] = dp_sit2[i-1]+1;
            }
            ans=(Integer)Math.max(ans,dp_sit1[i]);
            ans=(Integer)Math.max(ans,dp_sit2[i]);
        }
        return ans;
    }
}