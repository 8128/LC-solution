import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start=0, end=len;
        int[] oldlist = new int[len];
        for (int i=0;i<len;i++){
            oldlist[i]=nums[i];
        }
        Arrays.sort(nums);
        for (int i=0;i<len;i++){
            if(oldlist[i]!=nums[i]){
                start=i;
                break;
            }
        }
        for (int j=(len-1);j>=0;j--){
            if(oldlist[j]!=nums[j]){
                end=j;
                break;
            }
        }
        if (start==0&&end==len){
            return 0;
        }else{
            return (end-start+1);
        }
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        int[] test = {2,6,4,8,10,9,15};
        mSolution.findUnsortedSubarray(test);
    }
}