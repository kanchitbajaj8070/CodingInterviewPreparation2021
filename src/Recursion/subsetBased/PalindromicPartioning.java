package Recursion.subsetBased;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartioning
{
    public static void main(String[] args) {
        String s="0204451881";
        String g="aba";
        palidromicPartitioning(g,0,new ArrayList<>());
    }
    public static boolean isPalin(String s)
    {
        return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);
    }
    private static void palidromicPartitioning(String s, int processedSoFar, List<String> ans)
    {
        if(processedSoFar==s.length())
        {
            System.out.println(ans);
            return;
        }
        for(int k=processedSoFar+1;k<=s.length();k++)
        {
            String str=s.substring(processedSoFar,k);
            if(isPalin(str))
            {
                ans.add(str);
                palidromicPartitioning(s,k,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}
