class Solution {
    public int repeatedStringMatch(String A, String B) {
        String temp = A;
        int i=1;
        while(!temp.contains(B)){
            i++;
            temp=temp+A;
            if(temp.length()>B.length()+2*A.length()){
                break;
            }
        }
        if(temp.contains(B)) return i;
        else return -1;
    }
}