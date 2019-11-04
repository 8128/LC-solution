class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (numRows<=0) return ans;
        List<Integer> init = new LinkedList<Integer>();
        init.add(1);
        ans.add(init);
        if (numRows==1) return ans;
        return helper(1,numRows,ans);
    }
    
    public List<List<Integer>> helper(int i, int numRows, List<List<Integer>> ans){
        List<Integer> row = new LinkedList<Integer>();
        row.add(1);
        for(int j=1;j<i;j++){
            List<Integer> lastrow = ans.get(i-1);
            row.add(lastrow.get(j-1)+lastrow.get(j));
        }
        row.add(1);
        ans.add(row);
        if(i<numRows-1){
            helper(++i,numRows,ans);
        }
        return ans;
    }
}