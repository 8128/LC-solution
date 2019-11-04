class Solution647 {
    // official answer
    public int official_countSubstrings(String S) {
      int N = S.length(), ans = 0;
      for (int center = 0; center <= 2*N-1; ++center) {
          int left = center / 2;
          int right = left + center % 2;
          while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
              ans++;
              left--;
              right++;
          }
      }
      return ans;
    }
    // my answer
    public static int countSubstrings(String s) {
      int len = s.length();
      int result = len;
      char[] charlist = new char[len];
      charlist = s.toCharArray();
      for(int i=0;i<len;i++){
        for(int j=(len-1);j>i;j--){
          //System.out.println("Case:");
          //System.out.println(i);
          //System.out.println(j);
          int front_cursor = i;
          int end_cursor = j;
          while (charlist[front_cursor]==charlist[end_cursor]){
            if (end_cursor==front_cursor+1||end_cursor==front_cursor+2){
              result++;
              //System.out.println("right output");
              break;
            }else{
              front_cursor++;
              end_cursor--;
            }
          }
        }
      }
      return result;
    }

    public static void main(String[] args) {
      System.out.print("The result is:");
      System.out.println(countSubstrings("aaaaa"));
    }
}
