class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left=0,right=0;
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(a=='(') left++;
            if(left==0){
                if(a==')') right++;
            }else if(a==')'){
                left--;
            }
        }
        List<String> ans = new ArrayList<String>();
        dfs(s,0,left,right,ans);
        return ans;
    }
    
    public void dfs(String s, int start, int left, int right, List<String> ans){
        if(left==0&&right==0){
            if(checkVaild(s)) ans.add(s);
        }
        for(int i =start;i<s.length();i++){
            if(i>0&&s.charAt(i)==s.charAt(i-1)) continue;
            StringBuilder temp = new StringBuilder(s);
            if(s.charAt(i)=='('&&left>0){
                temp.deleteCharAt(i);
                dfs(temp.toString(),i,left-1,right,ans);
            }
            if(s.charAt(i)==')'&&right>0){
                temp.deleteCharAt(i);
                dfs(temp.toString(),i,left,right-1,ans);
            }
        }
    }
    
    public boolean checkVaild(String s){
        int temp=0;
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(a=='('){
                temp++;
            }else if(a==')'){
                temp--;
            }
            if(temp<0) return false;
        }
        return temp==0;
    }
}