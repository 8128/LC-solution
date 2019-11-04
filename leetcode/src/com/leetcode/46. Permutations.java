class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] flag = new int[nums.length];
        List<Integer> mList = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,flag,mList,ans);
        return ans;
    }
    
    public void helper(int[] nums, int[] flag, List<Integer> mList, List<List<Integer>> ans){
        for(int i=0;i<nums.length;i++){
            if(mList.size()==nums.length){
                ans.add(mList);
                return;
            } 
            if(flag[i]==0){
                List<Integer> mlist=new ArrayList(mList);
                mlist.add(nums[i]);
                int[] mflag=flag.clone();
                mflag[i]=-1;
                helper(nums,mflag,mlist,ans);
            }
        }
    }
}