// Given string array A and B. Return true if every string in B
// can be constructed by the string in A.
//  input:
//  A = ["ab","c","d"]
//  B = ["abc", "abd", "cd"]
//  output: true
//  A = ["ab", "c", "d"]
//  B = ["abe"]
//  output: false
public class isPrefix {
    public static void main(String[] args) {
        String[] words = {"ab", "c", "d"};
        String[] prefixs = {"abc", "abd", "cd"};
        System.out.println(isPrefix(prefixs, words));
    }
    public static boolean isPrefix(String[] prefixs, String[] words) {

        return false;
    }

}
