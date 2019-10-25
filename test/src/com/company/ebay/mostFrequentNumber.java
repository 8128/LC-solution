import java.util.*;

public class mostFrequentNumber {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 4};
        List<Integer> res = mostFrequentNumber(array);
        for (int val : res) {
            System.out.println(val);
        }
    }
    public static List<Integer> mostFrequentNumber(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        Collection<Integer> count = map.values();
        int max = Collections.max(count);
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
}
