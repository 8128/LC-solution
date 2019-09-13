import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

class Solution {
    public void reverseWords(char[] str) {
        Stack<Queue> mstack = new Stack();
        Queue<Character> q = new LinkedList<Character>();
        Queue<Character> empty_q = new LinkedList<Character>();
        empty_q.offer(' ');
        for(int i=0;i<str.length;i++){
            if(str[i]==' '){
                mstack.push(new LinkedList<>(q));
                mstack.push(new LinkedList<>(empty_q));
                while(!q.isEmpty()){
                    q.poll();
                }
            }else if(i==str.length-1){
                q.offer(str[i]);
                mstack.push(q);
            }else{
                q.offer(str[i]);
            }
        }
        int j=0;
        while(!mstack.isEmpty()){
            Queue<Character> temp_q = mstack.pop();
            while(!temp_q.isEmpty()){
                str[j]=temp_q.poll();
                j++;
            }
        }
    }
}

public class Solution186{
    public static void main(String[] args) {
        char[] str = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        new Solution().reverseWords(str);
        System.out.println(str);
    }
}