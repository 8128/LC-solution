class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        left[0]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
            //System.out.println("left"+i+" "+left[i]);
        }
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                right[nums.length-1]=1;
            }else{
                right[i]=right[i+1]*nums[i+1];
            } 
            res[i]=left[i]*right[i];
            //System.out.println("right"+i+" "+right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        mSolution.productExceptSelf(new int[]{1,2,3,4});
    }
}