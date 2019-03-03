class Solution {
    public static String licenseKeyFormatting(String S, int K) {
        S=S.replace("-","").toUpperCase();
        int pivot = S.length()%K;
        StringBuilder sb = new StringBuilder();
        sb.append(S.substring(0,pivot));
        while((pivot+K)<=S.length()){
            if(pivot!=0) sb.append('-');
            sb.append(S.substring(pivot,pivot+K));
            pivot=pivot+K;
        }
        return sb.toString();
      }
}