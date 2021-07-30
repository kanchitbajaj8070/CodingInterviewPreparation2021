package Recursion.backtracking;

import java.util.Arrays;

public class SudokoSolver {
    /*
    * grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
         {5, 2, 0, 0, 0, 0, 0, 0, 0},
         {0, 8, 7, 0, 0, 0, 0, 3, 1},
         {0, 0, 3, 0, 1, 0, 0, 8, 0},
         {9, 0, 0, 8, 6, 3, 0, 0, 5},
         {0, 5, 0, 0, 9, 0, 6, 0, 0},
         {1, 3, 0, 0, 0, 0, 2, 5, 0},
         {0, 0, 0, 0, 0, 0, 0, 7, 4},
         {0, 0, 5, 2, 0, 6, 3, 0, 0} }
Output:
          3 1 6 5 7 8 4 9 2
          5 2 9 1 3 4 7 6 8
          4 8 7 6 2 9 5 3 1
          2 6 3 4 1 5 9 8 7
          9 7 4 8 6 3 1 2 5
          8 5 1 7 9 2 6 4 3
          1 3 8 9 4 7 2 5 6
          6 9 2 3 5 1 8 7 4
          7 4 5 2 8 6 3 1 9
Explanation: Each row, column and 3*3 box of
the output matrix contains unique numbers.
*/
    public static void main(String[] args) {
     int[][]   grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        System.out.println(fillSudoko(grid));

    }

    static int[] getNextEmpySpaceAvailable(int[][]grid )
    {
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l <9 ; l++) {
                if(grid[k][l]==0)
                    return new int[]{k,l};
            }
        }
        return new int[]{-1,-1};
    }
    static boolean canPlaceDigit(int[][]grid,int r, int c, int digit)
    {
        for(int i=0;i<9;i++)
        {
            if(grid[r][i]==digit||grid[i][c]==digit)
                return false;
        }
        int subgridRow=r-r%3;
        int subgridCol=c-c%3;
        for (int i = subgridRow; i <subgridRow+3 ; i++) {
            for(int j=subgridCol;j<subgridCol+3;j++)
            {
                if(digit==grid[i][j])
                return false;
            }
        }
        return true;
    }
    private static boolean fillSudoko(int[][] grid) {

        int[]next=getNextEmpySpaceAvailable(grid);
        if(next[0]==-1) {
            for(int[]d:grid)
                System.out.println(Arrays.toString(d));
            System.out.println("***********************");
            return true;
        }
        int r=next[0];
        int c=next[1];
        for (int digit = 1; digit <=9 ; digit++)
        {
            if(canPlaceDigit(grid,r,c,digit))
            {
                grid[r][c]=digit;
               if( fillSudoko(grid))
                   return true;
                grid[r][c]=0;
            }
        }
        return false;//if none of digit works which means not possible
        //then all the steps to reach this stage are erased
    }
}
