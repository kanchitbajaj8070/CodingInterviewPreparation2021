package Recursion.week1;

public class PrintNnumbers {
    public static void main(String[] args) {
        printInIncreasingOrder(5);
        System.out.println();
        printInDereasingOrder(5);
    }
    public static void printInIncreasingOrder( int n)
    {
        if(n==0)
            return;
        printInIncreasingOrder(n-1);
        System.out.print(n+"    ");
    }

    public static void printInDereasingOrder( int n)
    {
        if(n==0)
            return;
        System.out.print(n+"    ");
        printInIncreasingOrder(n-1);

    }
}
