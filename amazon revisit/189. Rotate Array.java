class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        int j=0;
        if(nums.length==0 || nums.length==1) return;
        if(k>nums.length) return;
        for(int i=0;i<nums.length;i++){
            if(i<nums.length-k){
                res[i+k]=nums[i];
            }else{
                res[j]=nums[i];
                j++;
            }
        }
        nums=res;
        for(int temp:nums){
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        mSolution.rotate(nums, 3);
    }
}


public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}