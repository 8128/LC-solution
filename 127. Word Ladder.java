// dont know where the problem is yet

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
    
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
    
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
    
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
    
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
    
            beginSet = temp;
            len++;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        List<String> mList = new LinkedList<String>();
        mList.add("hot");
        mList.add("dot");
        mList.add("dog");
        // mList.add("lot");
        // mList.add("log");
        // mList.add("cog");
        System.out.println(mSolution.ladderLength("hit","cog",mList));
    }
}