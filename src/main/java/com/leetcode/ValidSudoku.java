package com.leetcode;

/**
 * @Description : https://leetcode.cn/problems/valid-sudoku/
 * @Author : wuqia
 * @Date : 2023/1/30 20:31
 * @Version : 1.0
 **/
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // 每列
        for (int i = 0; i < 9; i++) {
            boolean[] hSign = new boolean[9];
            boolean[] lSign = new boolean[9];
            for (int j = 0; j < 9; j++) {
                // 每行
                char c = board[i][j];
                if (c != '.') {
                    if (hSign[c - '1']) {
                        return false;
                    } else {
                        hSign[c - '1'] = true;
                    }
                }
                // 每列
                c = board[j][i];
                if (c != '.') {
                    if (lSign[c - '1']) {
                        return false;
                    } else {
                        lSign[c - '1'] = true;
                    }
                }
            }
        }
        // 3-3小格   (i:0-3 j:0-3)\(i:0-3 j:3-6)\(i:0-3 j:6-9)
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                boolean[] sign = new boolean[9];
                for (int k = i * 3; k < (i + 1) * 3; k ++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        // 每列
                        char c = board[k][l];
                        if (c != '.') {
                            if (sign[c - '1']) {
                                return false;
                            } else {
                                sign[c - '1'] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(grid));
    }
}
