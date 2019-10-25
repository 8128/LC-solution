import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Give three array a, b and query. This one is hard to explain.
// Just read the example.
//Input:
//        a = [1, 2, 3]
//        b = [3, 4]
//        query = [[1, 5], [1, 1 , 1], [1, 5]]
//
//        Output:
//        [2, 1]

public class coolFeature {
    public static void main(String[] args) {

    }
    public static List<Integer> coolFeature(int[] a, int[] b, int[][] query) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) map.put(num, 1 + map.getOrDefault(num, 0));
        List<Integer> res = new ArrayList<>();
        for (int[] q : query) {
            // modify:
            if (q.length == 3) {
                b[q[1] - 0] = q[2];
            } else {
                // find sum, quite like 2-sum problem
                int sum = q[1], count = 0;
                for (int i = 0; i < b.length; ++i) {
                    int target = sum - b[i];
                    if (!map.containsKey(target)) continue;
                    count += map.get(target);
                }
                res.add(count);
            }
        }
        return res;
    }
}
