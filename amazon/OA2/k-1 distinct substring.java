import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution{
    public List<String> k_1(String s, int k) {
        if(k>s.length()) return null;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<k;i++){
            if(!hm.containsKey(s.charAt(i)-'a')){
                hm.put(s.charAt(i)-'a', 1);
            }else{
                hm.replace(s.charAt(i)-'a', hm.get(s.charAt(i)-'a')+1);
            }
        }
        if(hm.size()==k-1){
            ans.add(s.substring(0, k));
        }
        for(int i=k;i<s.length();i++){
            if(hm.get(s.charAt(i-k)-'a')-1==0) hm.remove(s.charAt(i-k)-'a');
            else hm.replace(s.charAt(i-k)-'a',hm.get(s.charAt(i-k)-'a')-1);
            if(!hm.containsKey(s.charAt(i)-'a')){
                hm.put(s.charAt(i)-'a', 1);
            }else{
                hm.replace(s.charAt(i)-'a', hm.get(s.charAt(i)-'a')+1);
            }
            if(hm.size()==(k-1)){
                ans.add(s.substring(i-k+1, i+1));
            }
        }   
        return ans;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.k_1("sainnoudocausonufaoscifuyoaumcyruoncroiufiuyaicunfiuafnopaicudouifnoaiupcfnsdnaslkjdcaoinuejnodieucioayhuilkjdshaiofhadbvksdhiofhahjdknfklasgfliaehaefuaopencpracfhanueypnfwuocpuniena", 4));
    }
}