import java.util.*;

public class Delete {
    public static void main(String[] args) {
        String s = "eavdivOs";
        System.out.println(delete(s));
    }
    public static String delete(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (set.contains(c)) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
