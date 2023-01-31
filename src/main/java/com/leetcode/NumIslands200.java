package com.leetcode;

/**
 * @Description : https://leetcode.cn/problems/number-of-islands/description/
 * @Author : wuqia
 * @Date : 2023/1/29 10:29
 * @Version : 1.0
 **/
public class NumIslands200 {

    public static int numIslands(char[][] grid) {
        int count = 0;
        // 遍历元素
        for (int i= 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                // 如果找到新的陆地则计数器加一，并把和此陆地关联的所有点都标记为2
                if (chars[j] == '1') {
                    count ++;
                    sign(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void sign(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid.length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            sign(grid, i - 1, j);
            sign(grid, i + 1, j);
            sign(grid, i, j - 1);
            sign(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
