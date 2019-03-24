import java.util.HashMap;

public class Solution{

    public int countKDistinctSubstring(String inputString, int num){
        int ans=0;
        for(int i=0;i<inputString.length();i++){
            HashMap<Character, Integer> hm = new HashMap<>();
            for(int j=i;j<inputString.length();j++){
                hm.put(inputString.charAt(j), hm.getOrDefault(inputString.charAt(j),0)+1);
                if(hm.size()==num){
                    ans++;
                    System.out.println(inputString.substring(i, j+1));
                } 
                if(hm.size()>num) break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.countKDistinctSubstring("abasadasfg", 3));
    }
}