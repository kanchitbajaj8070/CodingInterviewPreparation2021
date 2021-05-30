package Recursion.week1;

public class MultipliationWithoutOperator {
    public static void main(String[] args) {
        System.out.println(multiplicationWithoutStarOperator(9,8));
    }
    public static int multiplicationWithoutStarOperator( int a , int b)
    {

        //a*b=a+a+a+a ....b times
        if(b==0)
            return 0;

        return a+multiplicationWithoutStarOperator(a,b-1);
    }
}
