public class Problem3 {
    public static void main(String[] args) {
        String pattern = "bcd";
        String blogs = "bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32";
        System.out.println(calculate(pattern, blogs));
    }

    private static String calculate(String pattern, String blobs) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        String[] blob = blobs.split("\\|");
        int patternLen = pattern.length();
        for (String b : blob) {
            int res = 0;
            for (int i = 0, j = patternLen - 1; i < b.length() && j < b.length(); i++, j++) {
                if (b.substring(i, j + 1).equals(pattern)) {
                    res++;
                }
            }
            sb.append(res).append("|");
            sum += res;
        }
        sb.append(sum);
        return sb.toString();
    }

}
