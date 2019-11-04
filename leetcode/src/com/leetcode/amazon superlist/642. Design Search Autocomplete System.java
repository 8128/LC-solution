class AutocompleteSystem {
    HashMap<String, Integer> hm;
    int pos;
    LinkedList<String> candidates;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        hm = new HashMap<>();
        sb = new StringBuilder();
        pos=0;
        for(int i=0;i<sentences.length;i++){
            hm.put(sentences[i],times[i]);
        }
    }
    
    public List<String> input(char c) {
        if(c=='#'){
            String temp = sb.toString();
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            pos=0;
            sb=new StringBuilder();
            return new LinkedList<>();
        } 
        sb.append(c);
        if(pos==0) candidates = new LinkedList<>(hm.keySet());
        for(int i=0;i<candidates.size();i++){ 
            if(pos>candidates.get(i).length()-1 || candidates.get(i).charAt(pos)!=c){
                candidates.remove(i);
                i--;
            } 
        }
        Collections.sort(candidates,new Comparator<String>(){
            public int compare(String a, String b){
                if(hm.get(a)>hm.get(b)) return -1;
                if(hm.get(b)>hm.get(a)) return 1;
                int j=0;
                while(j<a.length() && j<b.length()){
                    if(a.charAt(j)>b.charAt(j)) return 1;
                    if(a.charAt(j)<b.charAt(j)) return -1;
                    j++;
                }
                if(a.length()>b.length()) return 1;
                else return -1;
            }
        });
        pos++;
        if(candidates.size()<=3) return candidates;
        else return candidates.subList(0,3);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */