class Solution {
    int[] nums;
    Random rd;

    public Solution(int[] nums) {
        rd = new Random();
        this.nums = nums;
    }
    
    public int pick(int target) {
        int result=-1, count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=target) continue;
            // the possibility of changing the former result to the next is 1/n
            if(rd.nextInt(++count)==0){
                result=i;
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */