import java.util.HashSet;
import java.util.Set;

// Give a number n and digit number k find all serial
// substring is able to divisible n.
//Input: n = 120, k = 2
//        Output: 2
//        Explain:
//        120 -> 12 and 20
//        120 % 12 == 0 (O)
//        120 % 20 == 0 (O)
//
//        Input: n = 555, k = 1;
//        Output: 1
//        Explain:
//        555 -> 5, 5 and 5 (Duplicate so only count one 5)
//        555 % 5 == 0 (O)
public class divisorSubstrings {
    public static void main(String[] args) {
        int n = 2345;
        int k = 2;
        System.out.println(divisorSubstrings(n, k));
    }

    public static int divisorSubstrings(int n, int k) {
        String number = String.valueOf(n);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < number.length() - k + 1; i++) {
            String val = "";
            for (int j = i; j < i + k; j++) {
                 val += number.charAt(j);
            }
            set.add(Integer.valueOf(val));
        }
        int res = 0;
        for (int key : set) {
            if (n % key == 0) res++;
        }
        return res;
    }
}
