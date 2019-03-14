class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] strings= s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=strings.length-1;i>=0;i--){
            //System.out.println(strings[i]);
            if(i!=strings.length-1) sb.append(" ");
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.reverseWords("  hello world!  "));
    }
}