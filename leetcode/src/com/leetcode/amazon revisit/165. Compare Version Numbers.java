class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int min = v1.length>v2.length ? v2.length : v1.length;
        int i=0;
        for(;i<min;i++){
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[i])) return 1;
            if(Integer.valueOf(v1[i])<Integer.valueOf(v2[i])) return -1;
        }
        String[] temp = v1.length>v2.length ? v1 : v2;
        boolean equal = true;
        for(;i<temp.length;i++){
            if(Integer.valueOf(temp[i])!=0) equal = false;
        }
        if(equal) return 0;
        return i=(v1.length>v2.length)?1:-1;
    }
}