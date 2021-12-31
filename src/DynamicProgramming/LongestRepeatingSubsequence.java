package DynamicProgramming;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
/*Input: “t o m o r r o w”
Output: 2
Explanation: The longest repeating subsequence is “or” {tomorrow}.
Example 2:
Input: “a a b d b c e c”
Output: 3
Explanation: The longest repeating subsequence is “a b c” {a a b d b c e c}.*/

    String a=" tomorrow”";
        System.out.println(solve(a,a,0,0));
    int[][]dp=new int[a.length()+1][a.length()+1];
    for(int i=1;i<=a.length();i++)
    {
        for(int j=1;j<=a.length();j++)
        {
            if(a.charAt(i-1)==a.charAt(j-1)&&i!=j)
                dp[i][j]=1+dp[i-1][j-1];
            else
                dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);

        }
    }
        System.out.println(dp[a.length()][a.length()]);
    for(int [] g:dp)
        System.out.println(Arrays.toString(g));
    }
    public static int solve(String a, String b,int i, int j)
    {
        if(i==a.length()||j==b.length())
            return 0;
        if(a.charAt(i)==b.charAt(j)&i!=j)
            return 1+solve(a,b,i+1,j+1);
        else
            return Math.max(solve(a,b,i+1,j),solve(a,b,i,j+1));
    }
}
