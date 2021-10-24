package Recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class WordBreak {
    /*
    * Given a valid sentence without any spaces between the words and a dictionary of valid English words, find all possible ways to break the sentence in individual dictionary words.

Example

Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,
  and, cream, icecream, man, go, mango}

Input: "ilikesamsungmobile"
Output: i like sam sung mobile
        i like samsung mobile
        */
    public static void main(String[] args) {
        String str="ilikesamsungmobile";
        String []dict={ "i", "like", "sam","sung", "samsung", "mobile", "ice",
                "and", "cream", "icecream", "man", "go", "mango"};
        System.out.println(getWordBreaks(dict,str,0,new ArrayList<>()));
    }
static boolean contains(String[]dict,String word)
{

    for(String a:dict)
    {
        if(a.equalsIgnoreCase(word))
            return true;
    }
    return false;
}
    private static int getWordBreaks(String[] dict, String str, int i, ArrayList<String> words) {

    if(i==str.length())
    {
        System.out.println(words.toString());
        return 1;
    }
    int ans=0;
    for(int j=i+1;j<=str.length();j++)
    {
       String substr=str.substring(i,j);
       if(contains(dict,substr))
       {
           words.add(substr);
          ans+= getWordBreaks(dict,str,j,words);
           words.remove(substr);
       }
    }
    return ans;
    }
}
