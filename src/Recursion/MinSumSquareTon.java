package Recursion;

public class MinSumSquareTon {

    public static void main(String[] args) {
        System.out.println(solve(6));

    }
    public static int solve(int n)
    {
        if(n==0)
            return 0;
        if(n<0)
            return Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++)
        {
            min=Math.min(min,1+solve(n-(i*i)));
        }
        return min;

    }
}
