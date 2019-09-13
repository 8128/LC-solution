import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if(len!=t.length()) return false;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<len;i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            hm.put(ch1,hm.getOrDefault(ch1,0)+1);
            hm.put(ch2,hm.getOrDefault(ch2,0)-1);
            if(hm.get(ch1)==0) hm.remove(ch1);
            if(hm.containsKey(ch2) && hm.get(ch2)==0) hm.remove(ch2);
        }
        if(hm.size()==0) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.isAnagram("anagram", "nagaram"));
    }
}