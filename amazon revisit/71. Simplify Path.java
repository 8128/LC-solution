class Solution {
    public String simplifyPath(String path) {
        String[] mlist = path.split("/");
        LinkedList<String> ans = new LinkedList<>();
        for(String temp:mlist){
            if(temp.equals(".") || temp.equals("")) continue;
            if(temp.equals("..")){
                if(!ans.isEmpty()) ans.pop();
            } 
            else ans.push(temp);
        }
        StringBuilder sb = new StringBuilder();
        while(!ans.isEmpty()){
            //System.out.println(ans.peek());
            sb.append("/"+ans.pollLast());
        }
        if(sb.length()==0) sb.append("/");
        return sb.toString();
    }
}