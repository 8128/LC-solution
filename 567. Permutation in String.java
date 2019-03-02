class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] st = new int[26];
        for(int i=0;i<s1.length();i++){
            st[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length()-s1.length()+1;i++){
            int[] temp = st.clone();
            for(int j=i;j<i+s1.length();j++){
                temp[s2.charAt(j)-'a']--;
            }
            if(helper(temp)) return true;
        }
        return false;
    }
    
    public boolean helper(int[] temp){
        boolean bl = true;
        for(int i=0;i<temp.length;i++){
            bl=bl&&(temp[i]==0);
        }
        return bl;
    }
}