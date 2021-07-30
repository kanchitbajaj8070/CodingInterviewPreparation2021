package Recursion.backtracking;

import java.util.Arrays;

public class KnightMove {
    /*Given a N*N board with the Knight placed on the first block of an empty board.
     Moving according to the rules of chess knight must visit each square exactly once.
    Print the order of each the cell in which they are visited.*/
    public static void main(String[] args)
    {
int[][]board=new int[8][8];
for(int[]d:board)
    Arrays.fill(d,-1);
board[0][0]=0;
        int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        System.out.println(knightTour(board,board.length,0,0,dx,dy,1));
        for(int[]d:board)
            System.out.println(Arrays.toString(d));
    }

    static boolean knightTour(int[][]board,int n, int i, int j,int[]dx,int[] dy,int count)
    {
        if(count==n*n)
            return true;
        for (int k = 0; k < dx.length ;k++) {
            if((i+dx[k]<n)&&(j+dy[k]<n)&&(i+dx[k]>=0)&&(j+dy[k]>=0)&&board[i+dx[k]][j+dy[k]]==-1) {
                board[i+dx[k]][j+dy[k]]=count;
                if(knightTour(board, n, i + dx[k], j + dy[k], dx, dy,count+1))
                    return true;
                    board[i + dx[k]][j + dy[k]] = -1;
            }
        }
        return false;

    }


}
