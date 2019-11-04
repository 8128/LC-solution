class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        ans.add(first);
        for(int i=0;i<nums.length;i++){
            int size = ans.size();
            for(int j=0;j<size;j++){
                List<Integer> copy = new ArrayList<>(ans.get(j));
                copy.add(nums[i]);
                ans.add(copy);
            }
        }
        return ans;
    }
}