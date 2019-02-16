import java.util.LinkedList;
import java.util.List;

class Solution{
    static String version1 = "0.5.2.04";
    static String version2 = "7.5.3";
    public static void main(String[] args) {
        // List<Integer> s = new LinkedList<Integer>();
        // for(String i:version1.split("\\.")){
        //     int j = Integer.valueOf(i);
        //     s.add(j);
        // }
        // System.out.println(s);
        int a = compareVersion(version1,version2);
        System.out.println(a);
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();        
        for(String a : v1s){
            int b = Integer.valueOf(a);
            list1.add(b);
        }
        for(String a : v2s){
            int b = Integer.valueOf(a);
            list2.add(b);
        }
        while(list1.size()>list2.size()){
            list2.add(0);
        }
        while(list2.size()>list1.size()){
            list1.add(0);
        }
        int len = list1.size();   
        for(int i=0;i<len;i++){
            if(list1.get(i)>list2.get(i)){
                return 1;
            }else if(list2.get(i)>list1.get(i)){
                return -1;
            }
        }
        return 0;
    }
}