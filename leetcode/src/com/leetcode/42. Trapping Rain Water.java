class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int leftmax=0, rightmax=0, ans=0;
        while(left<=right){
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if(leftmax<rightmax){
                ans+=(leftmax-height[left]);
                left++;
            }else{
                ans+=(rightmax-height[right]);
                right--;
            }
        }
        return ans;
    }
}