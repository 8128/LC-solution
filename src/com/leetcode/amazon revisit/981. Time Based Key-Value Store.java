class TimeMap {
    
    HashMap<String,TreeMap<Integer,String>> hm;

    /** Initialize your data structure here. */
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> tempHM = hm.getOrDefault(key,new TreeMap<Integer,String>());
        tempHM.put(timestamp,value);
        hm.put(key,tempHM);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        TreeMap<Integer,String> tempHM = hm.get(key);
        //you need to use Integer for the null type
        Integer temp = tempHM.floorKey(timestamp);
        if(temp==null) return "";
        return tempHM.get(temp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */