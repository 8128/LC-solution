//给一个String  连续三个字符不一样结果就+
//input"abccde"; output: 2 (abc,cde)
public class differentString {
    public static void main(String[] args) {
        String s = "aaaaabced";
        System.out.println(differentString(s));
    }

    public static int differentString(String s) {
        int res = 0;
        for (int i = 2; i < s.length(); i++) {
            int left = s.charAt(i - 2);
            int mid = s.charAt(i - 1);
            int right = s.charAt(i);
            if (right != mid && left != mid && right != left) {
                res++;
            }
        }
        return res;
    }
}
