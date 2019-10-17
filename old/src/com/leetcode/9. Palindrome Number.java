class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int def = x;
        Stack<Integer> stack = new Stack<Integer>();
        int ten=10;
        while(x!=0){
            int remain = x%ten;
            System.out.println(x);
            System.out.println(remain);
            stack.push(remain*10/ten);
            x=(x-remain)/10;
        }
        int ans=0;
        ten=1;
        while(!stack.isEmpty()){
            ans = ten*stack.pop()+ans;
            ten=ten*10;
        }
        System.out.println(ans);
        if(ans!=def){
            return false;
        }else{
            return true;
        }
    }
}