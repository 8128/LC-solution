import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> mList = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        mList.add(empty);
        for(int i=0;i<nums.length;i++){
            int count=0;
            while((i+count)<nums.length && nums[i+count]==nums[i]) count++;
            hm.put(nums[i],count);
            i=i+count-1;
        }
        for(int key:hm.keySet()){
            System.out.println(key+" "+hm.get(key));
            int size=mList.size();
            for(int i=0;i<size;i++){ 
                List<Integer> temp = new ArrayList<>(mList.get(i));
                if(temp.size()==3) break;
                for(int j=1;j<=hm.get(key);j++){
                    temp.add(key);
                    if(temp.size()>3) break;
                    List<Integer> mcopy = new ArrayList<>(temp);
                    mList.add(mcopy);
                }
            }
        }
        int ans=0;
        for(int i=0;i<mList.size();i++){
            for(int k:mList.get(i)){
                System.out.println(k);
            }
            System.out.println("-------");
            if(mList.get(i).size()!=3){
                mList.remove(i);
                i--;
                continue;
            }
            if(mList.get(i).get(0)+mList.get(i).get(1)<=mList.get(i).get(2)){
                mList.remove(i);
                i--;
                continue;
            }
            HashMap<Integer, Integer> temp_hm = new HashMap<>();            
            for(int k:mList.get(i)){
                //System.out.println(k);
                temp_hm.put(k,temp_hm.getOrDefault(k, 0)+1);
            }
            int temp=1;
            for(int key:temp_hm.keySet()){
                for(int j=0;j<temp_hm.get(key);j++){
                    temp *= (hm.get(key)-j);
                    temp /= (j+1);
                }
            }
            ans+=temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.triangleNumber(new int[]{1,2,3,4,5,6}));
    }
}