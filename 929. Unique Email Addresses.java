class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<String>();
        for(int i=0;i<emails.length;i++){
            StringBuilder sb = new StringBuilder(emails[i]);
            for(int j=0;j<sb.length();j++){
                if(sb.charAt(j)=='.') sb.deleteCharAt(j);
                if(sb.charAt(j)=='+'){
                    while(sb.charAt(j)!='@'){
                        sb.deleteCharAt(j);
                    }
                    break;
                }    
                if(sb.charAt(j)=='@') break;
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }
}


//official solution
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email: emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll(".", "");
            seen.add(local + rest);
        }

        return seen.size();
    }
}