package Graphs;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
       int  screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 3, 3, 3, 3, 0, 1, 0},
                {1, 1, 1, 3, 3, 0, 1, 0},
                {1, 1, 1, 3, 3, 3, 3, 0},
                {1, 1, 1, 1, 1, 3, 1, 1},
                {1, 1, 1, 1, 1, 3, 3, 1},
        };
       for( int[]d:screen) {
           System.out.println(Arrays.toString(d));
       }
       /* used to replace one type of color with another for the entrire connected component*/
    // like replace red with yellow , here we replae 1 to 2
    int[]dx={1,-1,0,0};
    int[]dy={0,0,1,-1};
    floodFill(screen,dx,dy,2,1,0,0);
        System.out.println(" ================================================= \n\n");
        for( int[]d:screen) {
            System.out.println(Arrays.toString(d));
        }

    }
    public static void floodFill(int[][] screen, int[]dx,int[]dy, int newColor, int oldColor
    ,int i , int j)
    {
        if(i<0||i>=screen.length||j<0||j>=screen.length)
            return;
        if( screen[i][j]!=oldColor)
            return;// be careful of i , j values . dnt include in above
        screen[i][j]=newColor;
        for (int k = 0; k <4 ; k++) {
            floodFill(screen,dx,dy,newColor,oldColor,i+dx[k],j+dy[k]);
        }

    }

}
