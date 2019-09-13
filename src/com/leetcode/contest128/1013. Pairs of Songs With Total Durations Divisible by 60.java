class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if(time.length<2) return 0;
        int count=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:time){
            int temp = i%60;
            hm.put(temp, hm.getOrDefault(temp,0)+1);
        }
        for(int key:hm.keySet()){
            if(key==30 || key==0){
                count+=(hm.get(key)*(hm.get(key)-1)/2);
                hm.replace(key,0);
            }
            if(hm.containsKey(60-key)){
                count+=(hm.get(key)*hm.get(60-key));
                hm.replace(60-key,0);
            } 
            hm.replace(key,0);
        }
        return count;
    }
}