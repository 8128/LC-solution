class Solution {
    public int trap(int[] height) {
        int ans=0;
        int i=0,j=height.length-1,leftmax=0,rightmax=0;
        while(j>i){
            if(height[i]<height[j]){
                leftmax = Math.max(leftmax,height[i]);
                ans+=leftmax-height[i];
                i++;
            }else{
                rightmax = Math.max(rightmax,height[j]);
                ans+=rightmax-height[j];
                j--;
            }
        }
        return ans;
    }
}