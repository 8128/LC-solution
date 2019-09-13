public class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int size = nums.length;
        for(int i=0;i<size-2;i++){
            int k=i+2;
            for(int j=i+1;j<size-1 && nums[i]!=0;j++){
                while(k<size && nums[i]+nums[j]>nums[k]){
                    k++;
                }
                ans+=k-j-1;
            }
        }
        return ans;
    }
}