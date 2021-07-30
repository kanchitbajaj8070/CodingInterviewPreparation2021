package Recursion.backtracking;

import java.util.Arrays;

public class EightQueens {
static int count=0;
    public static void main(String[] args) {
        int n = 8;
      //  solveNqueens(n);
        int[][]grid=new int[n][n];
        nQueenSolveAllSolutions(grid,0);
        System.out.println(count);
    }

    public static void solveNqueens(int n) {
        int[][] board = new int[n][n];
        nQueenSolve(board, 0);
    }

    public static boolean canPlace(int[][] board, int r, int c) {
        if (board[r][c] == 1)
            return false;
        for (int i = 0; i < board.length; i++)
            if (board[r][i]== 1 || board[i][c]== 1)
                return false;
        int ldr = r - 1;
        int ldc = c - 1;
        int rdr = r -1;
        int rdc = c + 1;
        while (ldc >= 0 && ldr >=0) {
            if (board[ldr][ldc] == 1)
                return false;
            ldc--;
            ldr--;
        }
        while (rdc < board.length && rdr >=0) {
            if (board[rdr][rdc] == 1)
                return false;
            rdc++;
            rdr--;
        }

        return true;
    }

    public static boolean nQueenSolve(int[][] grid, int i) {
        if (i == grid.length) {
            for (int[] d : grid)
                System.out.println(Arrays.toString(d));
            System.out.println("******************");
            return true;
        }
        for (int j = 0; j < grid.length; j++) {
            if (canPlace(grid, i, j)) {
                grid[i][j] = 1;
                if (nQueenSolve(grid, i + 1))
                    return true;
                grid[i][j] = 0;
            }
        }

        return false;
    }

    public static void nQueenSolveAllSolutions(int[][] grid, int i) {
        if (i == grid.length) {
            for (int[] d : grid)
                System.out.println(Arrays.toString(d));
            System.out.println("******************");
            count++;
            return;
        }
        for (int j = 0; j < grid.length; j++) {
            if (canPlace(grid, i, j)) {
                grid[i][j] = 1;
                nQueenSolveAllSolutions(grid, i + 1);
                grid[i][j] = 0;
            }
        }
    }
}
