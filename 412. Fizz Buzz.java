class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> mList = new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean a = (i+1)%3==0;
            boolean b = (i+1)%5==0;
            String temp;
            if(a&&b) temp = "FizzBuzz";
            else if(a) temp = "Fizz";
            else if(b) temp = "Buzz";
            else temp = Integer.toString(i+1);
            mList.add(temp);
        }
        return mList;
    }
}