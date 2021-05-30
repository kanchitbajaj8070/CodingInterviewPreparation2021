package Recursion.week1;

public class PowerFunction {

    public static void main(String[] args) {
        System.out.println(power(3,4));
    }


    public static int power(int base, int pow)
    {
        if(pow==0)
            return 1;
        return base * power(base,pow-1);
    }

}
