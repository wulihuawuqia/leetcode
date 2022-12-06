package com.algorithm.backtracking;

import org.junit.jupiter.api.Test;

/**
 * @Description : 八皇后问题
 * @Author : wuqia
 * @Date : 2022/10/12 09:51
 * @Version : 1.0
 **/
public class EightQueens {

    int[] result = new int[8];

    int count = 0;

    public void calc(int row) {
        if (row == 8) {
            printAndResetQueens(result);
            System.out.println(count++);
            return;
        }
        // 遍历每一列
        for (int column = 0; column < 8; column++) {
            // 确认可以，即可开始下一行
            if (isOk(row, column)) {
                result[row] = column;
                calc(row + 1);
            }
        }
    }

    public boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            // 第 i 行的 column 列有棋子吗?
            if (result[i] == column) return false;
            // 考察左上对角线:第 i 行 leftUp 列有棋子吗?
            if (leftUp >= 0) {
                if (result[i] == leftUp) return false;
            }
            if (rightUp < 8) { // 考察右上对角线:第 i 行 rightUp 列有棋子吗?
                if (result[i] == rightUp) return false;
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private void printAndResetQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void test() {
        calc(0);
    }
}
