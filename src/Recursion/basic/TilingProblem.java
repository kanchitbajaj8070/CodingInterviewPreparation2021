package Recursion.basic;

public class TilingProblem {
    public static void main(String[] args) {
        int n=6;//given by the user
        int height=4;
        int width=n;
        System.out.println(countWays(width));
        //if put it in vertical direction - we have n-1 rem space.
        //if we put inh horizontal then we have n-4 space left;
        //they cant be combined together because one takes full height ,
        //and one takes full width .//so f(n)=f(n-1)+f(n-4)

    }
    public static int countWays( int n)
    {
       if(n<4&&n>0)
       {
           return 1;
       }
       if(n<=0)
           return 0;
       if(n==4)
           return 2;
        int way1=countWays(n-1);//vertically placed
        int way2=countWays(n-4);//horizontally placed
        return way1+way2;
    }
}
