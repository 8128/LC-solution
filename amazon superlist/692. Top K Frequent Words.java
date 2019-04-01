class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String temp:words) hm.put(temp,hm.getOrDefault(temp,0)+1);
        List<String> ans = new ArrayList<>(hm.keySet());
        Collections.sort(ans,new Comparator<String>(){
            public int compare(String a, String b){
                if(hm.get(a)>hm.get(b)) return -1;
                if(hm.get(b)>hm.get(a)) return 1;
                return a.compareTo(b);
            }
        });
        return ans.subList(0,k);
    }
}