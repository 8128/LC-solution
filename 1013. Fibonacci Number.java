class Solution {
    public int fib(int N) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        return helper(N, hm);
    }
    
    public int helper(int N, HashMap<Integer,Integer> hm){
        if(N==0){
            return 0;
        }
        if(N<3){
            hm.put(N,1);
            return 1;
        }else{
            int a = hm.containsKey(N-2) ? hm.get(N-2) : helper(N-2,hm);
            int b = hm.containsKey(N-1) ? hm.get(N-1) : helper(N-1,hm);
            return a+b;
        }
    }
}