package Recursion.backtracking;

import java.util.Arrays;

public class RatInAMaze {
    public static void main(String[] args) {

        int m=4;
        int n=4;
        //m*n matrix
        //can move right or down only
        boolean[][]visited=new boolean[m][n];
  //  getPath(m,n,0,0,"",visited);
//        System.out.println(count);
        int[][]matrix={{0,0,0,0},
                        {0,0,1,0},
                        {0,0,0,1},
                        {0,1,0,0}};//1 denotes obstacles
        count=0;
        getPathWithObstances(m,n,0,0,"",visited,matrix);
        System.out.println(count);
//        int[][]matrix2={{0,0,0,0},
//                {0,0,1,0},
//                {0,0,1,1},
//                {0,1,0,0}};
//        System.out.println(doesPathExist(m,n,0,0,visited,matrix2));
    }
static int count=0;
    private static void getPath(int m, int n, int i, int j,String s, boolean[][]visited)
    {
        if(i>=m||j>=n)
            return;
        if(i==m-1&&j==n-1)
        {count++;
            System.out.println(s);
            for(boolean[]d: visited)
            {
                System.out.println(Arrays.toString(d));
            }
            System.out.println();
            return;
        }
        if(visited[i][j])
            return;
        visited[i][j]=true;
        getPath(m,n,i+1,j,s+"V",visited);
        getPath(m,n,i,j+1,s+"H",visited);
        visited[i][j]=false;
    }
    private static void getPathWithObstances(int m, int n, int i, int j,String s, boolean[][]visited,int[][]matrix)
    {
        if(i>=m||j>=n)
            return;
        if(i==m-1&&j==n-1)
        {count++;
            System.out.println(s);
            for(boolean[]d: visited)
            {
                System.out.println(Arrays.toString(d));
            }
            System.out.println();
            return;
        }
        if(visited[i][j]||matrix[i][j]==1)
            return;
        visited[i][j]=true;
        getPathWithObstances(m,n,i+1,j,s+"V",visited,matrix);
        getPathWithObstances(m,n,i,j+1,s+"H",visited,matrix);
        visited[i][j]=false; //backtracking step
    }

    public static boolean doesPathExist(int m, int n, int i, int j, boolean[][]visited,int[][]matrix)

    {
        if(i>=m||j>=n)
            return false;
            if(visited[i][j]||matrix[i][j]==1)
                return false;

            if(i==m-1&&j==n-1)
                return true;
            visited[i][j]=true;
            boolean goRight=doesPathExist(m,n,i,j+1,visited,matrix);
            boolean goDown=doesPathExist(m,n,i+1,j,visited,matrix);
        visited[i][j]=false;
        if(goDown||goRight)
            return true;
        else
            return false;
    }

}
