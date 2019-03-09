class Solution {
    public int maxProduct(int[] nums) {
        int cur = nums[0];
        int min = cur;
        int max = cur;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i],max * nums[i]);
            min = Math.min(nums[i],min * nums[i]);
            cur = Math.max(cur,max);
        }
        return cur;
    }
}


// memory overflow
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int[][] ans = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            ans[i][i]=nums[i];
            max = Math.max(max,nums[i]);
            for(int j=i+1;j<nums.length;j++){
                ans[i][j]=ans[i][j-1]*nums[j];
                max = Math.max(max,ans[i][j]);
            }
        }
        return max;
    }
}