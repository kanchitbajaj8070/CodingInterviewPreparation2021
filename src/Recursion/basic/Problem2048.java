package Recursion.basic;

import java.util.HashMap;
import java.util.Map;

public class Problem2048 {
    static Map<Integer,String> map=new HashMap<>();
    public static void main(String[] args) {
        int n=2048;

            map.put(0,"zero");
            map.put(1,"one");
            map.put(2,"two");
            map.put(3,"three");
            map.put(4,"four");
            map.put(5,"five");
            map.put(6,"six");
            map.put(7,"seven");
            map.put(8,"eight");
            map.put(9,"nine");
             print(n);
    }

    public static void print( int number)
    {
        if( number==0)
                 return;
        int num=number%10;
        print(number/10);
        System.out.print(map.get(num)+" ");
    }

    }

