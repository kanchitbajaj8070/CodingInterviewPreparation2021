package Recursion.basic;

public class CountBinaryStrings {
    public static void main(String[] args) {
        int n=4;
        //n=1, ans =2; 0 or 1
        //n=2 , ans =3 ,00 or 01 or 10
        //n=3, ans =5 ,000, 001, 100 ,010 ,101,
        //f(n-1) + f(n-2)?-dependign on previous value
        //ansr for n=4 is 8 (from net) for 5=13
        System.out.println(countWays(5,false));
    }
    public static int countWays(int n,boolean isPrevOne)
    {
        if(n==0)
            return 0;
        if(n==1)
        {
            if(isPrevOne)
                return 1;
            else
                return 2;
        }
        int place_zero=countWays(n-1,false);
        int place_one=0;
        if(!isPrevOne)
        {
            place_one+=countWays(n-1,true);
        }
        return place_one+place_zero;

    }
}

