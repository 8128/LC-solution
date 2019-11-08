package com.v.bloomberg.coding;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 11/8/2019 2:48 AM
 * @leetcode :  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
}
