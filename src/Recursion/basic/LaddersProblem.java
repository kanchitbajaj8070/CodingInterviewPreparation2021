package Recursion.basic;

public class LaddersProblem {
    public static void main(String[] args) {
        int n=4;
        System.out.println(countWays(n));
    }
    public static int countWays(int n)
    {
        if(n==1||n==2)
            return n;
        if(n==3)
            return 4;
        return countWays(n-1)+countWays(n-2)+countWays(n-3);
    }
}
