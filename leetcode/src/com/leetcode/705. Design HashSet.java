class MyHashSet {

    //load factor(L) = 10000/numBuckets = 0.7
    List<Integer>[] lists;
    int numBuckets = 13000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        lists = new LinkedList[numBuckets];
    }
    
    public int hashing(int key)
    {
        return key%numBuckets;
    }
    
    //time: O(L)
    public void add(int key) {
        int i = hashing(key);
        if(lists[i]==null)
            lists[i] = new LinkedList<>();
        if(lists[i].indexOf(key)==-1) lists[i].add(key);
    }
    
    //time: O(L)
    public void remove(int key) {
        int i = hashing(key);
        if(lists[i]==null) return;
        if(lists[i].indexOf(key)!=-1) lists[i].remove(lists[i].indexOf(key));
    }
    
    //time: O(L)
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = hashing(key);
        if(lists[i]==null||lists[i].indexOf(key)==-1)
            return false;
        else
            return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */