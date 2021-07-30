package Recursion.basic;

public class FriendsPairingProblem {
    public static void main(String[] args) {
        int n=4;
        //we have n friends that wat to go to a party. they can go single or as a couple.
        //find total no  of ways.


    }
    private static int countWays(int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;

        return countWays(n-1)+(n-1)*countWays(n-2);
        //we has nC1 to for a couple with the rem. n-1 people
        //f(n-1)+nC1*f(n-2);
    }
}
