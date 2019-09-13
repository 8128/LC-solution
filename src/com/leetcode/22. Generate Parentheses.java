class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}




class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> mlist = new ArrayList<String>();
        if(n==0) return mlist;
      StringBuilder sb = new StringBuilder("(");
      ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
      deque.push(0);
      helper(n-1,n,mlist,deque,sb);
      return mlist;
  }

  public void helper(int l, int r, List<String> mlist, ArrayDeque<Integer> deque,StringBuilder sb){
      if(r>0){
          StringBuilder temp = new StringBuilder(sb);
          ArrayDeque<Integer> q = deque.clone();
          if(!q.isEmpty()){
              q.pop();
              temp.append(")");
              helper(l,r-1,mlist,q,temp);
          }
      }
      if(l>0){
          StringBuilder temp = new StringBuilder(sb);
          ArrayDeque<Integer> q = deque.clone();
          q.push(0);
          temp.append("(");
          helper(l-1,r,mlist,q,temp);
      }
      if(r==0&&l==0){
          mlist.add(sb.toString());
      }
  }
}