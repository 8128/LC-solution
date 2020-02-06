import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(NPalindrome(195));
    }
    static int time = 0;
    static int sum = 0;
    public static List<Integer> NPalindrome(int x) {
        int rev = reverse(x);
        if (rev != x) {
            sum = x + rev;
            time++;
            NPalindrome(sum);
        }
        return new ArrayList<>(Arrays.asList(time, sum));
    }
    public static int reverse(int x) {
        int y = x;
        int res = 0;
        while(y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return res;
    }
}
