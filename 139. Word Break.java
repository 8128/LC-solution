class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] bl = new boolean[s.length()+1];
        bl[0]=true;
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(bl[j]&&wordDict.contains(s.substring(j,i))){
                    bl[i]=true;
                }
            }
        }
        return bl[s.length()];
    }
}

// thats my trash Solution

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder temp = new StringBuilder(s);
        return helper(temp,wordDict);
    }
    
    public boolean helper(StringBuilder sb, List<String> wordDict){
        boolean bl = false;
        for(int i=0;i<wordDict.size();i++){
            if(sb.indexOf(wordDict.get(i))!=-1){
                StringBuilder temp = new StringBuilder(sb);
                temp.replace(sb.indexOf(wordDict.get(i)),sb.indexOf(wordDict.get(i))+wordDict.get(i).length(),"#");
                if(temp.toString().replace("#","").length()==0) return true;
                bl = bl||helper(temp,wordDict);
            }
        }
        return bl;
    }
}