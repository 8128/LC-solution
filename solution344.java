class Solution {
    public void reverseString(char[] s) 
    {
        int length = s.length;
        for(int i = 0; i < length/2; i++){
            int nulength = length-1-i;
            char temp = s[i];
            s[i] = s[nulength];
            s[nulength] = temp;
        }
    }
}
