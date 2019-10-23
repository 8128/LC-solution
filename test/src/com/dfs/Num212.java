package com.dfs;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-22 03:38
 */
public class Num212 {
    int[][] dire = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0) {
            return new ArrayList<>();
        }
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (String str : words) {
                    if (str.charAt(0) != board[i][j]) continue;
                    if (ans.contains(str)) continue;
                    char[] charArray = str.toCharArray();
                    boolean[][] seen = new boolean[board.length][board[0].length];
                    if (track(board, seen, charArray, 0, i, j)) {
                        ans.add(str);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public boolean track(char[][] board, boolean[][] seen, char[] charArray, int index, int x, int y) {
        seen[x][y] = true;
        if (board[x][y] == charArray[index] && index == charArray.length - 1) {
            return true;
        } else if(board[x][y] == charArray[index]) {
            boolean bl = false;
            for (int i = 0; i < 4; i++) {
                int tempX = x + dire[i][0];
                int tempY = y + dire[i][1];
                if (tempX < board.length && tempX >= 0 && tempY < board[0].length && tempY >= 0 && !seen[tempX][tempY]) {
                    bl = bl || track(board, seen.clone(), charArray, index + 1, tempX, tempY);
                }
            }
            return bl;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Num212 num212 = new Num212();
        System.out.println(num212.findWords(new char[][]{{'a','b'},{'c','d'}}, new String[]{"bacd"}));
    }
}
