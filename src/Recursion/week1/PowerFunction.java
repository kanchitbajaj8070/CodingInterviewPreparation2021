package Recursion.week1;

public class PowerFunction {

    public static void main(String[] args) {
        System.out.println(power(3,4));
        System.out.println(fast_power(3,4));
    }


    public static int power(int base, int pow)
    {
        if(pow==0)
            return 1;
        return base * power(base,pow-1);
    }
    public static int fast_power( int base,int pow)
    {
        if(pow==0)
            return 1;
        if(pow==1)
            return base;
        int smallAns= fast_power(base,pow/2);
        if(pow%2==0)
        {

            return smallAns*smallAns;
        }
        else
        {
            return smallAns*smallAns*base;
        }

    }

}
