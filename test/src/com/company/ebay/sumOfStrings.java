import java.util.LinkedList;

public class sumOfStrings {
    public static void main(String[] args) {
        String a = "999999";
        String b = "222221111";
        System.out.println(sumOfStrings(a, b));
    }
    public static String sumOfStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> res = new LinkedList<>();
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int i, j;
        for (i = arrayA.length - 1, j = arrayB.length - 1; i >= 0 && j >= 0; i--, j--) {
            int indexA = arrayA[i] - '0';
            int indexB = arrayB[j] - '0';
            res.addFirst(indexA + indexB);
        }
        if (i >= 0) {
            for (int k = i; k >= 0; k--) res.addFirst(arrayA[k] - '0');
        }
        if (j >= 0) {
            for (int k = j; k >= 0; k--) res.addFirst(arrayB[k] - '0');
        }
        for (int index = 0; index < res.size(); index++) {
            sb.append(res.get(index));
        }
        return sb.toString();
    }
}
