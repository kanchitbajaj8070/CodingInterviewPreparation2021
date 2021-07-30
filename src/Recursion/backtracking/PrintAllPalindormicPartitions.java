package Recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPalindormicPartitions {
    public static void main(String[] args) {
       String s="geekforgeeks";
       printAllPalindromicPartitions(s,0,new ArrayList<>());
    }
    public static  boolean isPalin(String s)
    {
    return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);

    }
    public static void printAllPalindromicPartitions(String s, int i , List<String> list)
    {
        if(i==s.length())
        {
            System.out.println(list.toString());
            return;
        }
        for (int j = i+1; j <= s.length(); j++) {
            String a=s.substring(i,j);
            if(isPalin(a))
            {
                list.add(a);
                printAllPalindromicPartitions(s,j,list);
                list.remove(list.size()-1);
            }

        }

    }



}
