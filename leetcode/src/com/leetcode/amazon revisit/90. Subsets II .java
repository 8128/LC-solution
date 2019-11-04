import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int count=0;
            while(count+i<nums.length && nums[count+i]==nums[i]){
                count++;
            } 
            hm.put(nums[i],count);
            i+=count-1;
        }
        List<Integer> empty = new ArrayList<>();
        ans.add(empty);
        for(int key:hm.keySet()){
            //System.out.println(key+"  "+hm.get(key));
            int size=ans.size();
            for(int i=0;i<size;i++){
                List<Integer> copy = new ArrayList<>(ans.get(i));
                for(int j=0;j<hm.get(key);j++){
                    copy.add(key);
                    List<Integer> mcopy = new ArrayList<>(copy);
                    ans.add(mcopy);
                }
            }
        }   
        return ans;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.subsetsWithDup(new int[]{1,2,2}));
    }
}