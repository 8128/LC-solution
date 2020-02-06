import java.util.ArrayList;
import java.util.List;

public class Location {
    public static void main(String[] args) {

    }

    public String direction(int[] x, int[] y) {
        if (x[0] == y[0] && x[1] == y[1]) return "here";
        if (x[0] == y[0] && x[1] < y[1]) return "N";
        if (x[0] == y[0] && x[1] > y[1]) return "S";
        if (x[0] < y[0] && x[1] == y[1]) return "E";
        if (x[0] > y[0] && x[1] == y[1]) return "W";
        if (x[0] < y[0] && x[1] < y[1]) return "NE";
        if (x[0] < y[0] && x[1] > y[1]) return "SE";
        if (x[0] > y[0] && x[1] > y[1]) return "SW";
        if (x[0] > y[0] && x[1] < y[1]) return "NW";
        return "-1";
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> row = new ArrayList();
        for(int i = 0; i < numRows; i++) {
            for(int j = row.size() - 1; j >= 1 ; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
            res.add(new ArrayList(row));
        }
        return res;
    }
}

