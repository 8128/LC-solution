package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 03:18
 * @leetcode :  https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length() != digits.length()){
            //Retrieves and removes the head (first element) of this list.
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove + c);
            }
        }
        return ans;
    }
}
