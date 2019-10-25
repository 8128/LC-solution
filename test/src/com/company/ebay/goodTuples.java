// Give an array and find the count of a pair number and
// a single number combination in a row of this array.
// Target array is a[i - 1], a[i], a[i + 1]
public class goodTuples {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 5, 3, 2, 3};
        System.out.println(goodTuples(array));
    }
    public static int goodTuples(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] == array[i] && array[i - 1] != array[i + 1]) {
                count++;
            }
            if (array[i] == array[i + 1] && array[i - 1] != array[i]) {
                count++;
            }
            if (array[i - 1] == array[i + 1] && array[i] != array[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
