class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums.length==0) return ans;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int a:nums){
            if(!hm.containsKey(a)){
                hm.put(a,1);
            }else{
                hm.replace(a,hm.get(a)+1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(hm.get(b)-hm.get(a)));
        for(int key:hm.keySet()){
            pq.add(key);
        }
        while(ans.size()!=k){
            ans.add(pq.poll());
        }
        return ans;
    }
}