class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String temp:strs){
            char[] charTemp = temp.toCharArray();
            Arrays.sort(charTemp);
            String key = String.valueOf(charTemp);
            //System.out.println(key);
            List<String> mList = hm.getOrDefault(key, new ArrayList<String>());
            mList.add(temp);
            hm.put(key,mList);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> temp:hm.values()){
            res.add(temp);
        }
        return res;
    }
}