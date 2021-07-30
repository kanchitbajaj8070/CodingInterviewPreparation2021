package Recursion.subsetBased;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedBrackets {
    public static void main(String[] args)
    {
        generateBrackets(3,"",0,0);
        List<String> ans= new ArrayList<>();
        getGenerateBrackets(3,"",0,0,ans);
        System.out.println("**************************");
        System.out.println(ans);
    }
    private static void generateBrackets(int n,String s,int open,int close)
    {
        if(2*n==s.length())
        {
            System.out.println(s);
            return;
        }
        if(open<n)
        {
            generateBrackets(n,s+"(",open+1,close);
        }
        if(close<open)
        {
            generateBrackets(n,s+")",open,close+1);
        }

    }
    private static void getGenerateBrackets(int n,String s,int open,int close,
                                            List<String> ans)
    {
        if(2*n==s.length())
        {
            ans.add(s);
            return;
        }
        if(open<n)
        {
            getGenerateBrackets(n,s+"(",open+1,close,ans);
        }
        if(close<open)
        {
            getGenerateBrackets(n,s+")",open,close+1,ans);
        }
}
}
