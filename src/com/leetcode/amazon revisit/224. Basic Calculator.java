import java.util.*;

class Solution {
    
    public int calculate(String s) {
        int ans=0;
        int num=0;
        int sign=1;
        Stack<Integer> mStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            //System.out.println("ans "+ans);
            //System.out.println("num "+num);
            //System.out.println("-----"+i);
            char c = s.charAt(i);
            if((c-'0')>=0 && (c-'0')<10){
                //System.out.println("--------");
                num=num*10+Integer.valueOf(c-'0');
                //System.out.println(num);

            }else if(c=='('){
                if(num!=0){
                    ans+=num;
                    num=0;
                } 
                mStack.push(ans);
                mStack.push(sign);
                ans=0;
                sign=1;
            }else if(c==')'){
                if(sign==-1) num=-num;
                ans = ans+=num;
                if(mStack.pop()==-1){
                    ans = -ans;
                }
                ans += mStack.pop();
                num=0;
            }else if(c=='-'){
                if(sign==-1) num = -num;
                ans+=num;
                sign=-1;
                num=0;
            }else if(c=='+'){
                if(sign==-1) num = -num;
                ans+=num;
                sign=1;
                num=0;
            }else{
                if(sign==-1) num = -num;
                ans+=num;
                num=0;
            }
        }
        if(num!=0){
            if(sign==-1) num=-num;
            ans+=num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        System.out.println(mSolution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}