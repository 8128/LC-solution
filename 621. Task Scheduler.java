import java.util.ArrayList;
import java.util.Arrays;


class Solution621 {
    // official answer
    public int leastInterval(char[] tasks, int n) {
        // create a map for 26 kinds of tasks, and sort by increasing order
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            // n is cooling time needed
            int i = 0;
            while (i <= n) {
                System.out.println(map[25-i]);
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                System.out.println(map[25-i]);
                time++;
                System.out.println(time);
                i++;
                System.out.println(i);
                System.out.println("------------------");
            }
            Arrays.sort(map);
        }
        return time;
    }

    // this is a wrong answer because it did not take order into consideration
    public int myleastInterval(char[] tasks, int n) {
        int length = tasks.length;
        int[] alphabet = new int[26];
        for (int i=0;i<length;i++) {
            char mchar = tasks[i];
            alphabet[(int)mchar - 65]++;
        }
        int[] ans = new int[1000000];
        // init all process to idle(27)
        for (int i=0;i<1000000;i++){
            ans[i] = 27;
        }
        // char exist
        for (int i=0;i<26;i++){
            int m=0;
            while(alphabet[i]!=0){
                // find empty position for it
                while (ans[m]!=27) {
                    m++;
                }
                ans[m] = i;
                alphabet[i]--;
                m+=(n+1);
            }
        }
        int mfinal = 999999;
        while(ans[mfinal]==27){
            mfinal--;
        }
        // test
        for (int k=0;k<10;k++){
            System.out.println(ans[k]);
        }
        return mfinal+1;

    }

    public static void main(String[] args) {
        String a = "AAAB";
        char[] charlist = a.toCharArray();
        Solution621 solution = new Solution621();
        System.out.println(solution.leastInterval(charlist,1));
    }
}