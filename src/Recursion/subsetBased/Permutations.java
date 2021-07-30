package Recursion.subsetBased;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permutations("abc"));
        System.out.println();
        swapMethodForFindingPermutations("abc".toCharArray(),0);
    }
    public static List<String> permutations(String unprocessed)
    {
        if(unprocessed.isEmpty())
        {
            List<String> arr=new ArrayList<>();
            arr.add("");
            return arr;
        }
        List<String> ans=new ArrayList<>();
        char ch=unprocessed.charAt(0);
        List<String> smallAns=permutations(unprocessed.substring(1));

        for(String s:smallAns)
        {
            for(int i=0;i<=s.length();i++)
            {
                String str=s.substring(0,i)+ch+s.substring(i);
            ans.add(str);
            }
        }

        return ans;

    }
    private static void swapMethodForFindingPermutations(char[]s,int i)
    {
        if(i==s.length)
        {
            String ans=new String(s);
            System.out.print(ans+"  ");
            return;
        }
        for(int j=i;j<s.length;j++)
        {
            swap(s,i,j);
          swapMethodForFindingPermutations(s,i+1);
          swap(s,i,j);
        }
    }
    private static void swap(char[] s , int i, int j)
    {
        char c=s[i];
        s[i]=s[j];
        s[j]=c;
    }
}
