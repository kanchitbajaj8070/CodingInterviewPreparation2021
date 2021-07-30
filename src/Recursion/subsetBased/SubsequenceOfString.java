package Recursion.subsetBased;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfString {
    public static void main(String[] args) {
String s="abc";
subsequences(s,"");
        System.out.println();
        System.out.println(getSubsequences("abc"));

    }
public static void subsequences(String unprocessed, String processed)
{
    if(unprocessed.isEmpty())
    {
        if(processed.isEmpty())
            System.out.println("empty");
        else
        System.out.print(processed+"    ");
        return;
    }
    char ch=unprocessed.charAt(0);
    subsequences(unprocessed.substring(1),processed+ch);
    subsequences(unprocessed.substring(1),processed);
}
public static List<String> getSubsequences(String unprocessed)
{
    if(unprocessed.isEmpty())
    {
        List<String> list=new ArrayList<>();
        list.add("");
        return list;
    }
    List<String> ans=new ArrayList<>();
    char ch=unprocessed.charAt(0);
    List<String> restOfStringAns=getSubsequences(unprocessed.substring(1));
    for(String s:restOfStringAns)
    {
        ans.add(s);
        ans.add(ch+s);
    }
    return ans;

}
}
