package Recursion.basic;

public class Fibonacci {
    public static void main(String[] args) {
        int n=10;
        // 0 1 1 2 3 5 8 13 21 34 55
        System.out.println(nthFibonacciTerm(n));
    }
    private static int nthFibonacciTerm ( int n)
    {
        if( n==1)
            return 0;//1st fibonacci term
        if( n==2)
            return 1;//2nd fibonacci term

        int nMinusOneTerm=nthFibonacciTerm(n-1);
        int nMinusTwoTerm=nthFibonacciTerm(n-2);
        return nMinusOneTerm+nMinusTwoTerm;

    }
}
