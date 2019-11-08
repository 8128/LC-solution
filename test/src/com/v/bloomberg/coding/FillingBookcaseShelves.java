package com.v.bloomberg.coding;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 11/8/2019 3:07 AM
 * @leetcode :  https://leetcode.com/problems/filling-bookcase-shelves/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class FillingBookcaseShelves {
    /*
    For each book, we first put it on a new level of the shelf which is the least preferable way to do,
    in this case the current height will be dp[i - 1] + books[i- 1][1].
    Then, we check back previously put books and see if it is possible
    to get better arrangement(less height) by putting the current book
    together with the books at previous level of the shelf.
    If better arrangement is possible, dp[i] will be updated.
    The inner loop will terminate once accumulated width exceeds the bookshelf's width.
    */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];

        dp[0] = 0;

        for (int i = 1; i <= books.length; ++i) {
            int width = books[i-1][0];
            int height = books[i-1][1];
            dp[i] = dp[i-1] + height;
            for (int j = i - 1; j > 0 && width + books[j-1][0] <= shelf_width; --j) {
                height = Math.max(height, books[j-1][1]);
                width += books[j-1][0];
                dp[i] = Math.min(dp[i], dp[j-1] + height);
            }
        }
        return dp[books.length];
    }
}
