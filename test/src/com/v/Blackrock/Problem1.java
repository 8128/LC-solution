public class Problem1 {

    public static void main(String[] args) {
        String s = "And now          this:";
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toLowerCase().toCharArray();
        while (i < j) {
            while (i < s.length() && !isValid(c[i])) i++;
            while (j >= 0 && !isValid(c[j])) j--;
            while (i < j) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int len = 0; len < c.length; len++) {
            if (isValid(c[len])) {
                sb.append(c[len]).append("-");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

}
