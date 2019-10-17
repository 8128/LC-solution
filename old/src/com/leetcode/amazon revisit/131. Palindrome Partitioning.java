class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s,0,ans,new ArrayList<String>());
        return ans;
    }
    
    public void helper(String s, int pos, List<List<String>> ans, List<String> tempList){
        if(pos==s.length()){
            ans.add(tempList);
            return;
        } 
        for(int temp=pos;temp<s.length();temp++){
            if(checkPalindrome(s,pos,temp)){
                List<String> copyList = new ArrayList<>(tempList);
                copyList.add(s.substring(pos,temp+1));
                helper(s,temp+1,ans,copyList);
            }
        }
    }
    
    public boolean checkPalindrome(String s,int left, int right){
        if(left==right) return true;
        while(right>left){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}